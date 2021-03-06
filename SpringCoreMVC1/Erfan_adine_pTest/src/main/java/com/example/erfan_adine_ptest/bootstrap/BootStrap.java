package com.example.erfan_adine_ptest.bootstrap;

import com.example.erfan_adine_ptest.dto.core.BasePersonDto;
import com.example.erfan_adine_ptest.entity.core.BasePerson;
import com.example.erfan_adine_ptest.entity.security.Role;
import com.example.erfan_adine_ptest.service.AdminService;
import com.example.erfan_adine_ptest.service.BasePersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class BootStrap implements CommandLineRunner {

    private  final AdminService adminService;

    @Override
    public void run(String... args) throws Exception {



        adminService.save(new BasePersonDto("erfan", "adine", "erfan@gmail.com", "123", "danial" ,""));

    }
}
