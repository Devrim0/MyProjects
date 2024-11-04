package com.streamify.service;

import com.streamify.dto.LoginRequest;
import com.streamify.entities.User;
import com.streamify.exception.InvalidCredentialException;
import com.streamify.exception.UserNotFoundException;
import com.streamify.repository.UserRepository;
import com.streamify.util.JwtUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


/*@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @Mock
    private UserRepository userRepository;

    @Mock
    private AuthenticationManager authenticationManager;
    @Mock
    private JwtUtil jwtUtil;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private UserService userService;

    private User user;

    @BeforeEach
    void setUp(){
        user = new User();
        user.setUsername("username");
        user.setPassword("password");
        user.setEmail("ozcaydevrim3@gmail.com");
    }

    @Test
    void testSaveUser(){
        when(passwordEncoder.encode(anyString())).thenReturn("encodedPassword");
        when(userRepository.save(any(User.class))).thenReturn(user);
        User savedUser = userService.saveUser(user);

        assertNotNull(savedUser);
        assertEquals("encodedPassword", savedUser.getPassword());
        verify(userRepository, times(1)).save(any(User.class));
    }

    @Test
    void testFindUsername_UserFound() {
        when(userRepository.findByUsername(anyString())).thenReturn(Optional.of(user));
        User foundUser = userService.findByUsername("testuser");
        assertNotNull(foundUser);
        assertEquals("testuser", foundUser.getUsername());
        verify(userRepository, times(1)).findByUsername(anyString());
    }

    @Test
    void  testFindUserByUsername_UserNotFound(){
        when(userRepository.findByUsername(anyString())).thenReturn(Optional.empty());
        assertThrows(UserNotFoundException.class, ()->userService.findByUsername("nonexistentUser"));
    }

    @Test
    void testAuthenticateAndGenerateToken_Success(){
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("testUser");
        loginRequest.setPassword("password");
        Authentication authentication = mock(Authentication.class);
        when(authenticationManager.authenticate(any(UsernamePasswordAuthenticationToken.class))).thenReturn(authentication);
        when(jwtUtil.generateToken(any(Authentication.class))).thenReturn("token");

        String token = userService.authenticateAndGenerateToken(loginRequest);

        assertNotNull(token);
        assertEquals("token", token);

    }

    @Test
    void testAuthenticateAndGenerateToken_InvalidToken(){
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("testuser");
        loginRequest.setPassword("wrongpassword");

        when(authenticationManager.authenticate(any(UsernamePasswordAuthenticationToken.class)))
                .thenThrow(new InvalidCredentialException("Invalid username or password"));
        assertThrows(InvalidCredentialException.class, ()-> userService.authenticateAndGenerateToken(loginRequest));
    }

}
*/