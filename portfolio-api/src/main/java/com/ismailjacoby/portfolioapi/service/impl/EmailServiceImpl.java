package com.ismailjacoby.portfolioapi.service.impl;

import com.ismailjacoby.portfolioapi.models.form.ContactForm;
import com.ismailjacoby.portfolioapi.service.EmailService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl  implements EmailService {
    private final JavaMailSender mailSender;

    public EmailServiceImpl(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Value("${CONTACT_RECEIVER_EMAIL}")
    private String contactReceiverEmail;

    @Override
    public void sendContactEmail(ContactForm form) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(contactReceiverEmail);
        message.setSubject("New Contact Message" + form.subject());
        message.setText(
                "From: " + form.firstName() + " " + form.lastName() + "\n" +
                "Email: " +  form.email() + "\n" +
                "Company: " + (form.company() != null ? form.company() : "n/a") + "\n\n" +
                form.message()
        );
        mailSender.send(message);
    }


}
