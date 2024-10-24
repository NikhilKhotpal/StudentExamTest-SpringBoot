package com.test.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.Service.EmailService;
import com.test.Service.ExamService;
import com.test.Service.OtpService;
import com.test.Service.UserRepository;
import com.test.studentModel.AdminLogin;
import com.test.studentModel.ExamRequest;
import com.test.studentModel.LoginModel;
import com.test.studentModel.StudentModel;
import com.test.studentModel.UserModel;


@RestController
@CrossOrigin
public class MainController {
	@Autowired
	ExamService service;
	@Autowired
	private JavaMailSender javaMailSender;
	
	 @Autowired
	    private OtpService otpService;
	    
	 
	@Autowired
	private EmailService emailService;
	@GetMapping("/hiii")
	public String getresponse() {
		return "<h1>Welcome To SpringBoot</h1>";
		
		
	}
	@PostMapping("/savestudent")
	public ResponseEntity<String> SaveStudent(@RequestBody StudentModel sm) {
		
			service.SaveStudent(sm);
		
		return ResponseEntity.ok("success");
		
	}
	@PostMapping(path = "/dologininto")
	public ResponseEntity<String> dologin(@RequestBody LoginModel lm){
		List<UserModel> listi=service.login(lm);
		
        boolean isAuthenticated = authenticateUser(lm); // Your auth logic here
        
            

        
		if(isAuthenticated && listi != null && !listi.isEmpty()) {
			sendAdminNotification(lm.getEmail());
			return ResponseEntity.ok("success");
		}else {
			return ResponseEntity.ok("error");	
		}
		
		
	}
	private void sendAdminNotification(String email) {
		// TODO Auto-generated method stub
		 SimpleMailMessage message = new SimpleMailMessage();
	        message.setTo("khotpalnikhil492@gmail.com");  // Admin's email address
	        message.setSubject("User Login Notification");
	        message.setText("User '" + email + "' has logged in.");
	        
	        // Send the email
	        
	        javaMailSender.send(message);
	}
	private boolean authenticateUser(LoginModel lm) {
		// TODO Auto-generated method stub
		UserModel user = service.findByEmail(lm.getEmail());

	    // Check if the user exists and password matches
	    if (user != null && user.getPassword().equals(lm.getPassword())) {
	        return true; // Authentication successful
	    }

	    return false; // Authentication failed

	}
	@PostMapping("/startExam")
    @ResponseBody
    public ResponseEntity<String> startExam(@RequestBody ExamRequest examRequest) {
        // Handle the start exam logic here
        // For example, save the subject and start time to the database

        // Assuming ExamRequest is a class with subject and startTime fields
        System.out.println("Starting exam for subject: " + examRequest.getSubject());
        System.out.println("Start time: " + examRequest.getStartTime());

        // Return a response
        return ResponseEntity.ok("{\"status\":\"success\"}");
    }
	@PostMapping(path = "/Adminlogin")
	public ResponseEntity<String> Admilogin(@RequestBody AdminLogin lm){
		List<AdminLogin> listi=service.Adminlogin(lm);
		if(listi!=null) {
			return ResponseEntity.ok("success");
		}else {
			return ResponseEntity.ok("error");	
		}
		
	}
	@PostMapping("/change-password1")
    public boolean changePassword(@RequestParam String email, @RequestParam String password) {
        return service.getchangepassword(email, password);
    }
    
	
}	
	
	
