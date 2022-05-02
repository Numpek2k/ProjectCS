package com.example.hotdoctors;

import com.example.hotdoctors.Users.profession.Profession;
import com.example.hotdoctors.Users.users.UserService;
import com.example.hotdoctors.Users.users.Users;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class HotDoctorsApplication {

    public static void main(String[] args) {
        SpringApplication.run(HotDoctorsApplication.class, args);
    }
    @Bean
    BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }




}
