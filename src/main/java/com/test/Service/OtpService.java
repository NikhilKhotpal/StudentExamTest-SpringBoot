package com.test.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.test.Dao.MainDao;
import com.test.studentModel.Otp;
import com.test.studentModel.UserModel;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Service
public class OtpService {
    @Autowired
    private OtpRepository otpRepository;

    @Autowired
	private EntityManager em1;
    
    @Autowired
    private MainDao maindao;
   @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;

    // Assuming you have an EmailService to send emails
    @Autowired
    private EmailService emailService; // Make sure to create this service

    public String generateOtp(@RequestParam String email) {
        // Generate a random OTP
        Random random = new Random();
        int otpValue = random.nextInt(899999) + 100000; // Generates a 6-digit OTP
        String otpCode = String.valueOf(otpValue);
        
        // Send OTP via email (make sure your email service is implemented)
        emailService.sendEmail(email, otpCode, otpCode); // Update this method as per your implementation
        
        // Create and save the OTP record
        Otp otp = new Otp();
        otp.setEmail(email);
        otp.setOtpCode(otpCode);
        otp.setExpiryTime(LocalDateTime.now().plusMinutes(5)); // Set expiry time for 5 minutes
        otpRepository.save(otp);

        return otpCode; // For testing, return the OTP (in production, do not return OTP)
    }

    public boolean verifyOtp(String email, String otpCode) {
        List<Otp> otps = otpRepository.findByEmail(email);
        for (Otp otp : otps) {
            if (otp.getOtpCode().equals(otpCode) && otp.getExpiryTime().isAfter(LocalDateTime.now())) {
                // OTP is valid, handle accordingly
                UserModel user = userRepository.findByEmail(email);
                if (user != null) {
                    user.setVerified(true);
                    userRepository.save(user);
                }
                return true;
            }
        }
        return false; // No valid OTP found
    }
    @Transactional
    public boolean changePassword(String email, String password) {
    	UserModel user = userRepository.findByEmail(email);
        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
            user.setPassword(passwordEncoder.encode(password));
            userRepository.save(user);
            return true;
        }
        return false; 
    }
}

