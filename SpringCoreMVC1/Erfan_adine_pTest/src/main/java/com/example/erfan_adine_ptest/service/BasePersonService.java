package com.example.erfan_adine_ptest.service;

import com.example.erfan_adine_ptest.dto.in.user.WorkerInDto;
import com.example.erfan_adine_ptest.dto.out.user.WorkerOutDto;
import com.example.erfan_adine_ptest.entity.core.BasePerson;
import com.example.erfan_adine_ptest.exception.*;
import com.example.erfan_adine_ptest.repository.BasePersonRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BasePersonService implements UserDetailsService {
    private final BasePersonRepo basePersonRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

            BasePerson basePerson = basePersonRepo.findByUsername(username)
                    .orElseThrow(() -> new RuntimeException("not found user with username:" + username));

            return basePerson;
    }


    @Transactional
    public BasePerson create(BasePerson basePerson) throws NameNotValidException, EmailNotValidException, PasswordNotValidException, NullFieldException, BadEntryException {

        return basePersonRepo.save(basePerson);

    }
}
