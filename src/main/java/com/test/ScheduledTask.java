package com.test;

import java.time.LocalDateTime;

import org.springframework.scheduling.annotation.Scheduled;

public class ScheduledTask {
	  // Runs every 5 seconds
    @Scheduled(fixedRate = 5000)
    public void runTask() {
        System.out.println("Task running at: " + LocalDateTime.now());
    }

    // Runs at a specific time (e.g., every day at 12:00 PM)
    @Scheduled(cron = "0 0 12 * * ?")
    public void runDailyTask() {
        System.out.println("Daily task running at: " + LocalDateTime.now());
    }
}
