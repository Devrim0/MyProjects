package com.devrim.topicanalysis.topics.service;

import com.devrim.topicanalysis.topics.dtos.LoginRequest;
import com.devrim.topicanalysis.topics.dtos.UserDTO;

public interface UserService {
    UserDTO registerUser(UserDTO userDTO);
    UserDTO loginUser(LoginRequest loginRequest);
    UserDTO getAuthenticatedUser();
}
