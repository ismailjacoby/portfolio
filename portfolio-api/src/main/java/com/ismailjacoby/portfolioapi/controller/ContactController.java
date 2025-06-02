package com.ismailjacoby.portfolioapi.controller;

import com.ismailjacoby.portfolioapi.models.form.ContactForm;
import com.ismailjacoby.portfolioapi.service.EmailService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/contact")
public class ContactController {
    private final EmailService emailService;

    public ContactController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping
    public ResponseEntity<String> sendContactMessage(@RequestBody @Valid ContactForm form) {
        emailService.sendContactEmail(form);
        return ResponseEntity.ok("Your message has been sent successfully.");
    }
}
