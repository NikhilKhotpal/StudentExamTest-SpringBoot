package com.test.controller;

import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/exam")
public class ExamController {

    private LocalDateTime examStartTime;
    private LocalDateTime examEndTime;

    @PostMapping("/start")
    public String startExam() {
        examStartTime = LocalDateTime.now();
        return "Exam started at: " + examStartTime;
    }

    @PostMapping("/end")
    public String endExam() {
        examEndTime = LocalDateTime.now();
        long durationInMinutes = java.time.Duration.between(examStartTime, examEndTime).toMinutes();
        return "Exam ended at: " + examEndTime + ", Duration: " + durationInMinutes + " minutes";
    }
}
