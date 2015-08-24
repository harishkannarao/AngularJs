package com.harishkannarao.angularjs.service;

import com.harishkannarao.angularjs.model.AuthAccessElement;
import com.harishkannarao.angularjs.model.AuthAccessElementBuilder;
import com.harishkannarao.angularjs.model.AuthLoginElement;
import com.harishkannarao.angularjs.model.User;

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

    public Optional<AuthAccessElement> login(AuthLoginElement loginElement) {
        Optional<User> optionalUser = userService.findByUsernameAndPassword(loginElement.getUsername(), loginElement.getPassword());
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            String authToken = UUID.randomUUID().toString();
            user.setAuthToken(authToken);
            userService.save(user);
            AuthAccessElement authAccessElement = AuthAccessElementBuilder.newBuilder()
                    .setAuthId(user.getUsername())
                    .setAuthToken(authToken)
                    .setAuthPermissions(user.getAuthRoles())
                    .build();
            return Optional.of(authAccessElement);
        } else {
            return Optional.empty();
        }
    }

    public boolean isAuthorized(String username, String authToken, Set<String> rolesAllowed) {
        boolean authorized = false;
        Optional<User> optionalUser = userService.findByUsernameAndAuthToken(username, authToken);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            long permittedUserRolesCount = rolesAllowed.stream().filter(role -> user.getAuthRoles().contains(role)).count();
            if (permittedUserRolesCount > 0) {
                authorized = true;
            }
        }
        return authorized;
    }
}
