package com.test.Service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.test.studentModel.LoginModel;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;
    private Random random=new Random();
    // Send simple email
    public void sendEmail(String to, String subject, String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);
        javaMailSender.send(message);
    }
	public void sendEmail(String email, int otp) {
		// TODO Auto-generated method stub
		SimpleMailMessage msg=new SimpleMailMessage();
		System.out.println(""+email);
		   msg.setTo(email);
		   msg.setFrom("waghmareb69@gmail.com");
		   msg.setSubject("Your Otp Is");
		   msg.setText(""+otp);
		   javaMailSender.send(msg);
	}
    
   
    
}
