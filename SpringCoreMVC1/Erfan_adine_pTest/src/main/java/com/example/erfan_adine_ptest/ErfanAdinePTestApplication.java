package com.example.erfan_adine_ptest;

import com.example.erfan_adine_ptest.entity.core.BasePerson;
import com.example.erfan_adine_ptest.entity.security.Role;
import com.example.erfan_adine_ptest.service.BasePersonService;
import com.example.erfan_adine_ptest.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class ErfanAdinePTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(ErfanAdinePTestApplication.class, args);
    }


}