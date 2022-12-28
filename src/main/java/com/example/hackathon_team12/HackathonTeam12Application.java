package com.example.hackathon_team12;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class HackathonTeam12Application {

    public static void main(String[] args) {
        SpringApplication.run(HackathonTeam12Application.class, args);
    }

}
