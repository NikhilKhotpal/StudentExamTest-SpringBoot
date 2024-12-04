package com.test.Service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.studentModel.Otp;

public interface OtpRepository extends JpaRepository<Otp, Long> {
    List<Otp> findByEmail(String email);
}
