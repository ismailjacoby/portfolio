package com.ismailjacoby.portfolioapi.controller;

import com.ismailjacoby.portfolioapi.models.dto.AuthDTO;
import com.ismailjacoby.portfolioapi.models.form.LoginForm;
import com.ismailjacoby.portfolioapi.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("login")
    public ResponseEntity<AuthDTO> login(@RequestBody @Valid LoginForm form) {
        AuthDTO authDTO = authService.login(form);
        return ResponseEntity.ok(authDTO);
    }
}
