package com.streamify.controller;

import com.streamify.dto.LoginRequest;
import com.streamify.entities.User;
import org.springframework.http.ResponseEntity;

public interface UserController {
    ResponseEntity<User> registerUser(User user);
    ResponseEntity<User> getUserByUsername(String username);
    ResponseEntity<String> login(LoginRequest loginRequest);
}
