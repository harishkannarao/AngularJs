package com.harishkannarao.angularjs.service;

import com.harishkannarao.angularjs.model.UserSession;

import javax.ejb.Stateless;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Stateless
public class UserSessionService {
    private static Map<String, UserSession> userSessionMap = new HashMap<>();

    public void save(UserSession userSession) {
        userSessionMap.put(userSession.getUsername(), userSession);
    }

    public Optional<UserSession> findByUsernameAndAuthToken(String username, String authToken) {
        UserSession userSession = userSessionMap.get(username);
        if (userSession != null && userSession.getAuthToken().equals(authToken)) {
            return Optional.of(userSession);
        } else {
            return Optional.empty();
        }
    }

    public void delete(String username, String authtoken) {
        UserSession userSession = userSessionMap.get(username);
        if (userSession != null && userSession.getAuthToken().equals(authtoken)) {
            userSessionMap.remove(username);
        }
    }
}
