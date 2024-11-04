package com.devrim.topicanalysis.topics.service.impl;

import com.devrim.topicanalysis.topics.dtos.LoginRequest;
import com.devrim.topicanalysis.topics.dtos.UserDTO;
import com.devrim.topicanalysis.topics.entites.User;
import com.devrim.topicanalysis.topics.exception.UsernameNotFoundException;
import com.devrim.topicanalysis.topics.repository.UserRepository;
import com.devrim.topicanalysis.topics.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements  UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ModelMapper modelMapper;

    public UserDTO registerUser(UserDTO userDTO) {
        if (userRepository.existsByEmail(userDTO.getEmail())) {
            throw new IllegalArgumentException("Email is already in use");
        }
        User user = modelMapper.map(userDTO, User.class);
        user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt())); // Şifre hashleme
        User savedUser = userRepository.save(user);
        return modelMapper.map(savedUser, UserDTO.class);
    }

    public UserDTO loginUser(LoginRequest loginRequest) {
        User user = userRepository.findByUsername(loginRequest.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        if (!BCrypt.checkpw(loginRequest.getPassword(), user.getPassword())) {
            throw new IllegalArgumentException("Invalid credentials");
        }
        return modelMapper.map(user, UserDTO.class);
    }

    public UserDTO getAuthenticatedUser() {
        // Kimlik doğrulama mekanizması ile oturum açmış kullanıcıyı döndürme
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return modelMapper.map(user, UserDTO.class);
    }
}
