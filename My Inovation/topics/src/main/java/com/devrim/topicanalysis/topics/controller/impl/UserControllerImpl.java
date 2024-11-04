package com.devrim.topicanalysis.topics.controller.impl;

import com.devrim.topicanalysis.topics.controller.UserController;
import com.devrim.topicanalysis.topics.dtos.LoginRequest;
import com.devrim.topicanalysis.topics.dtos.UserDTO;
import com.devrim.topicanalysis.topics.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class UserControllerImpl implements UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserDTO> registerUser(@RequestBody UserDTO userDTO) {
        UserDTO createdUser = userService.registerUser(userDTO);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<UserDTO> loginUser(@RequestBody LoginRequest loginRequest) {
        UserDTO userDTO = userService.loginUser(loginRequest);
        return ResponseEntity.ok(userDTO);
    }

    @GetMapping("/profile")
    public ResponseEntity<UserDTO> getUserProfile() {
        // Kimlik doğrulama ve kullanıcı bilgilerini alarak profil döndürme
        UserDTO userDTO = userService.getAuthenticatedUser();
        return ResponseEntity.ok(userDTO);
    }
}
