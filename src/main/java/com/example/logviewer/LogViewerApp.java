package com.example.logviewer;

import com.example.logviewer.log.Log;
import com.example.logviewer.log.LogRepository;
import com.example.logviewer.user.CompanyUser;
import com.example.logviewer.user.CompanyUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LogViewerApp {
    @Autowired
    private LogRepository logRepository;
    @Autowired
    private CompanyUserRepository userRepository;

    @Bean
    public CommandLineRunner runner() {
        return (String... args) -> {
            logRepository.save(Log.builder().entry("test111").build());
            logRepository.save(Log.builder().entry("test123").build());
            logRepository.save(Log.builder().entry("test145").build());
            userRepository.save(CompanyUser.builder()
                    .userName("cp123")
                    .password("test")
                    .passwordExpired(true)
                    .companyId("CP111")
                    .build()
            );
            userRepository.save(CompanyUser.builder()
                    .userName("cp135")
                    .password("test")
                    .passwordExpired(false)
                    .companyId("CP444")
                    .build()
            );

        };
    }

    public static void main(String[] args) {
        SpringApplication.run(LogViewerApp.class, args);
    }
}
