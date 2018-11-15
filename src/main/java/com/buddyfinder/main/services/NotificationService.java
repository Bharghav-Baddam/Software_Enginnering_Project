package com.buddyfinder.main.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@Service
public class NotificationService {

    @Autowired
    private JavaMailSender sender;


    public void sendEmail() throws Exception{
        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper mimehelper = new MimeMessageHelper(message);

        mimehelper.setTo(InternetAddress.parse("bhavsarrutvik11@gmail.com"));
        mimehelper.setText("If you see this then it's from Service Class!");
        mimehelper.setSubject("BuddyFinder");

        sender.send(message);
    }

}





