package com.ismailjacoby.portfolioapi.service.impl;

import com.ismailjacoby.portfolioapi.exception.NotFoundException;
import com.ismailjacoby.portfolioapi.models.dto.AuthDTO;
import com.ismailjacoby.portfolioapi.models.entity.User;
import com.ismailjacoby.portfolioapi.models.form.LoginForm;
import com.ismailjacoby.portfolioapi.repository.UserRepository;
import com.ismailjacoby.portfolioapi.security.JwtProvider;
import com.ismailjacoby.portfolioapi.service.AuthService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final JwtProvider jwtProvider;

    public AuthServiceImpl(AuthenticationManager authenticationManager, UserRepository userRepository, JwtProvider jwtProvider) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.jwtProvider = jwtProvider;
    }

    @Override
    public AuthDTO login(LoginForm form) {
        String username = form.username().toLowerCase().trim();

        // Attempt to authenticate the user
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username, form.password())
            );
        } catch (AuthenticationException e) {
            throw new BadCredentialsException("Invalid username or password");
        }

        // Retrieve user from the database
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new NotFoundException("User not found"));

        String token = jwtProvider.generateToken(user.getUsername(), user.getRole());

        return AuthDTO.builder()
                .token(token)
                .username(user.getUsername())
                .role(user.getRole())
                .build();
    }
}
