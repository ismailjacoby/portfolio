package com.ismailjacoby.portfolioapi.service;

import com.ismailjacoby.portfolioapi.models.form.ContactForm;

public interface EmailService {
    void sendContactEmail(ContactForm form);
}
