package com.example.jmh;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class JmhApplication {

    public static void main(String[] args) {
        System.out.println("http://localhost:8080");
        SpringApplication.run(JmhApplication.class, args);
    }

    @RestController
    @RequestMapping("/")
    @RequiredArgsConstructor
    static class Hello {

        private final DbService dbService;
        private final ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1000);

        @PostConstruct
        private void init() {

            System.out.println("PostConstruct");
        }

        @GetMapping
        private String hello() {
            for (int i = 0; i < 1000; i++) {
                scheduledExecutorService.scheduleAtFixedRate(() -> dbService.put(UUID.randomUUID().toString(), UUID.randomUUID().toString()), 10, 1, TimeUnit.SECONDS);
            }
            return "hello!";
        }
    }

}
