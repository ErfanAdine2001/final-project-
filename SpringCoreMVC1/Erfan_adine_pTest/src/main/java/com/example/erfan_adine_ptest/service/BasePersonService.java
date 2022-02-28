package com.example.erfan_adine_ptest.service;

import com.example.erfan_adine_ptest.dto.core.BasePersonDto;
import com.example.erfan_adine_ptest.dto.in.user.WorkerInDto;
import com.example.erfan_adine_ptest.dto.out.BasPersonOutDto;
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
    private final WorkerService workerService;
    private final UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        BasePerson basePerson = basePersonRepo.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("not found user with username:" + username));

        return basePerson;
    }


    @Transactional
    public BasPersonOutDto create(BasePersonDto basePerson) throws NameNotValidException, EmailNotValidException, PasswordNotValidException, NullFieldException, BadEntryException {
        String type = basePerson.getType();
        return switch (type) {
            case "worker" -> workerService.save(basePerson);
            case "user" -> userService.save(basePerson);
            default -> null;
        };
    }
}
