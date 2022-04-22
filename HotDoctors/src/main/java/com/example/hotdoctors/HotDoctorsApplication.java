package com.example.hotdoctors;

import com.example.hotdoctors.Users.profession.Profession;
import com.example.hotdoctors.Users.users.UserService;
import com.example.hotdoctors.Users.users.Users;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HotDoctorsApplication {

    public static void main(String[] args) {
        SpringApplication.run(HotDoctorsApplication.class, args);
    }


    @Bean
    CommandLineRunner runner(UserService userService) {
        return args -> {
            userService.saveProfession(new Profession(null, "GINEKOLOG"));
            userService.saveProfession(new Profession(null, "DENTYSTA"));
            userService.saveProfession(new Profession(null, "OKULISTA"));
            userService.saveProfession(new Profession(null, "LEKARZ_RODZINNY"));

            //userService.saveUser(new Users(null, "Robert", "Makłowicz", "nakarmieciekoprem@gmail.com", "duszonewino123", "P"))



        };
    }


}
