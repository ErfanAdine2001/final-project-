package com.example.erfan_adine_ptest.service;

import com.example.erfan_adine_ptest.entity.core.BasePerson;
import com.example.erfan_adine_ptest.repository.BasePersonRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

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
}
