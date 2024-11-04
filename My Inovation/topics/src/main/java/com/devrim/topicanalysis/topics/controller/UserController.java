package com.devrim.topicanalysis.topics.controller;

import com.devrim.topicanalysis.topics.dtos.LoginRequest;
import com.devrim.topicanalysis.topics.dtos.UserDTO;
import org.springframework.http.ResponseEntity;

public interface UserController {
    ResponseEntity<UserDTO> registerUser(UserDTO userDTO);
    ResponseEntity<UserDTO> loginUser(LoginRequest loginRequest);
    ResponseEntity<UserDTO> getUserProfile();
}
