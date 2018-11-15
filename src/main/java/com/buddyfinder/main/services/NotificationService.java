package com.buddyfinder.main.services;

import com.buddyfinder.main.models.Account;
import com.buddyfinder.main.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@Service
public class NotificationService {


    @Autowired
    AccountRepository accountRepository;

    @Autowired
    private JavaMailSender sender;

    public void sendEmail(String to, String msg, String subject) throws Exception{

        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper mimehelper = new MimeMessageHelper(message);
        mimehelper.setTo(to);
        mimehelper.setText(msg);
        mimehelper.setSubject(subject);

        sender.send(message);
    }

}





