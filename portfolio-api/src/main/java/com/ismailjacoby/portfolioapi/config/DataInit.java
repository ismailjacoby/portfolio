package com.ismailjacoby.portfolioapi.config;

import com.ismailjacoby.portfolioapi.models.entity.User;
import com.ismailjacoby.portfolioapi.models.enums.UserRole;
import com.ismailjacoby.portfolioapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataInit  implements InitializingBean {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public DataInit(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Value("${ADMIN_USERNAME}")
    private String adminUsername;

    @Value("${ADMIN_PASSWORD}")
    private String adminPassword;

    @Override
    public void afterPropertiesSet() throws Exception {
        if (userRepository.findByUsername(adminUsername).isEmpty()) {
            User user = new User();
            user.setUsername(adminUsername);
            user.setPassword(passwordEncoder.encode(adminPassword));
            user.setRole(UserRole.ADMIN);
            userRepository.save(user);
        }
    }
}
