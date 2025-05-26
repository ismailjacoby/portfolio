package com.ismailjacoby.portfolioapi.service;

import com.ismailjacoby.portfolioapi.models.dto.AuthDTO;
import com.ismailjacoby.portfolioapi.models.form.LoginForm;

public interface AuthService {
    AuthDTO login(LoginForm form);
}
