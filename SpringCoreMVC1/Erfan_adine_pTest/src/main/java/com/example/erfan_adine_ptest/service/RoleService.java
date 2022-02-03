package com.example.erfan_adine_ptest.service;


import com.example.erfan_adine_ptest.entity.user.Role;
import com.example.erfan_adine_ptest.exception.*;
import com.example.erfan_adine_ptest.repository.RoleRepository;
import com.example.erfan_adine_ptest.service.util.Validation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.List;


@Service
@RequiredArgsConstructor
public class RoleService extends Common<Role, Long> {
    private final RoleRepository roleRepository;

    private Validation validation;

    @PostConstruct
    public void init() {
        setJpaRepository(roleRepository);
    }

    @Transactional
    public List<Role> gropById() {
        return roleRepository.GroupById();
    }

    @Override
    public Role save(Role entity) throws NullFieldException, BadEntryException, NameNotValidException, EmailNotValidException, PasswordNotValidException, NullAddresOfMainOrderException, NameOfSubServiceIsNull, NameOfMainServiceIsNull, OrderOfRequestIsNullException, NullCommentException, BasePriceOfSubServiceIsNull, AddressOfRequestIsNull, RoleIsNullException, OrderOfTransactionIsNullExeption, SuggestionOfPriceIsNullException {
        if (validation.RoleIsValid(entity))
            return super.save(entity);
        return null;
    }

    @Override
    public List<Role> findAll() {
        return super.findAll();
    }

    @Override
    public Role findById(Long id) {
        return super.findById(id);
    }

    @Override
    public void delete(Long id) {
        super.delete(id);
    }

    @Override
    public void update(Long id) throws NameNotValidException, NullFieldException, BadEntryException, EmailNotValidException, PasswordNotValidException, NullAddresOfMainOrderException, NameOfSubServiceIsNull, NameOfMainServiceIsNull, OrderOfRequestIsNullException, NullCommentException, BasePriceOfSubServiceIsNull, RoleIsNullException, AddressOfRequestIsNull, OrderOfTransactionIsNullExeption, SuggestionOfPriceIsNullException {
        super.update(id);
    }
}
