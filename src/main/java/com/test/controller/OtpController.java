package com.test.controller;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.test.Service.OtpService;

@RestController
@RequestMapping("/api/otp")
public class OtpController {
    @Autowired
    private OtpService otpService;

    @PostMapping("/generate")
    public String generateOtp(@RequestParam Map<String, String> request) {
    	String email = request.get("email");
        return otpService.generateOtp(email);
    }

    @PostMapping("/verify")
    public boolean verifyOtp(@RequestParam String email, @RequestParam String otpCode) {
        return otpService.verifyOtp(email, otpCode);
    }
    @PostMapping("/change-password")
    public boolean changePassword(@RequestParam String email, @RequestParam String password) {
        return otpService.changePassword(email, password);
    }
    
}
