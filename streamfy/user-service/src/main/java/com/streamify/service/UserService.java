package com.streamify.service;

import com.streamify.dto.LoginRequest;
import com.streamify.entities.User;

public interface UserService {
    User saveUser(User user);
    User findByUsername(String username);
    String authenticateAndGenerateToken(LoginRequest loginRequest);
}
