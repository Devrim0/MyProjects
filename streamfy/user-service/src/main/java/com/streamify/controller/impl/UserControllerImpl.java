package com.streamify.controller.impl;

import com.streamify.controller.UserController;
import com.streamify.dto.LoginRequest;
import com.streamify.entities.User;
import com.streamify.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserControllerImpl implements UserController {
    private final UserService userService;
    @PostMapping("/register")
    @Override
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        User savedUser = userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }

    @GetMapping("/{username}")
    @Override
    public ResponseEntity<User> getUserByUsername(@PathVariable String username) {
        User user= userService.findByUsername(username);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    @PostMapping("/login")
    @Override
    public ResponseEntity<String> login(LoginRequest loginRequest) {
        String token = userService.authenticateAndGenerateToken(loginRequest);
        return ResponseEntity.status(HttpStatus.OK).body(token);
    }
}
