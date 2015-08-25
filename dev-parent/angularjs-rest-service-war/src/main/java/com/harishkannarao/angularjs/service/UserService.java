package com.harishkannarao.angularjs.service;

import com.harishkannarao.angularjs.model.User;
import com.harishkannarao.angularjs.model.UserBuilder;

import javax.ejb.Stateless;
import java.util.*;

@Stateless
public class UserService {

    private static Map<String, User> users = createUsers();

    private static Map<String, User> createUsers() {
        Map<String, User> users = new HashMap<>();

        User user1 = UserBuilder.newBuilder()
                .setUsername("user1")
                .setPassword("pass1")
                .addAuthRole("role1")
                .addAuthRole("role2")
                .addAuthRole("role3")
                .build();
        User user2 = UserBuilder.newBuilder()
                .setUsername("user2")
                .setPassword("pass2")
                .addAuthRole("role1")
                .build();
        User user3 = UserBuilder.newBuilder()
                .setUsername("user3")
                .setPassword("pass3")
                .build();

        users.put(user1.getUsername(), user1);
        users.put(user2.getUsername(), user2);
        users.put(user3.getUsername(), user3);

        return users;
    }

    public Optional<User> findByUsernameAndPassword(String username, String password) {
        User user = users.get(username);
        if (user != null && user.getPassword().equals(password)) {
            return Optional.of(user);
        } else {
            return Optional.empty();
        }
    }

    public Optional<User> getUser(String username) {
        return Optional.ofNullable(users.get(username));
    }
}
