package com.harishkannarao.angularjs.service;

import com.harishkannarao.angularjs.constants.Roles;
import com.harishkannarao.angularjs.model.*;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Stateless
public class AuthService {

    @Inject
    private UserService userService;
    @Inject
    private UserSessionService userSessionService;

    public Optional<AuthAccessElement> login(AuthLoginElement loginElement) {
        Optional<User> optionalUser = userService.findByUsernameAndPassword(loginElement.getUsername(), loginElement.getPassword());
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            UserSession userSession = UserSessionBuilder.newBuilder()
                    .setUsername(user.getUsername())
                    .setAuthToken(UUID.randomUUID().toString())
                    .build();
            userSessionService.save(userSession);
            AuthAccessElement authAccessElement = AuthAccessElementBuilder.newBuilder()
                    .setAuthId(user.getUsername())
                    .setAuthToken(userSession.getAuthToken())
                    .setAuthPermissions(user.getAuthRoles().stream().map(Roles::getValue).collect(Collectors.toList()))
                    .build();
            return Optional.of(authAccessElement);
        } else {
            return Optional.empty();
        }
    }

    public boolean isAuthorized(String username, String authToken, Set<Roles> rolesAllowed) {
        boolean authorized = false;
        Optional<UserSession> optionalUserSession = userSessionService.findByUsernameAndAuthToken(username, authToken);
        Optional<User> userOptional = userService.getUser(username);
        if (optionalUserSession.isPresent() && userOptional.isPresent()) {
            User user = userOptional.get();
            long permittedUserRolesCount = rolesAllowed.stream().filter(role -> user.getAuthRoles().contains(role)).count();
            if (permittedUserRolesCount > 0) {
                authorized = true;
            }
        }
        return authorized;
    }

    public Optional<AuthAccessElement> getAuthAccessElement(String username, String authToken) {
        Optional<UserSession> optionalUserSession = userSessionService.findByUsernameAndAuthToken(username, authToken);
        Optional<User> userOptional = userService.getUser(username);
        if (optionalUserSession.isPresent() && userOptional.isPresent()) {
            AuthAccessElement authAccessElement = AuthAccessElementBuilder.newBuilder()
                    .setAuthId(userOptional.get().getUsername())
                    .setAuthToken(optionalUserSession.get().getAuthToken())
                    .setAuthPermissions(userOptional.get().getAuthRoles().stream().map(Roles::getValue).collect(Collectors.toList()))
                    .build();
            return Optional.of(authAccessElement);
        } else {
            return Optional.empty();
        }
    }

    public void logout(String username, String authtoken) {
        userSessionService.delete(username, authtoken);
    }
}
