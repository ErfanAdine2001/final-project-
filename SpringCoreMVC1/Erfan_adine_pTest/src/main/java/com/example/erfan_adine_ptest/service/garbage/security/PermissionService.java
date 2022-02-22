package com.example.erfan_adine_ptest.service.security;

import com.example.erfan_adine_ptest.dto.in.security.PermissionInDto;
import com.example.erfan_adine_ptest.dto.out.security.PermissionOutDto;
import com.example.erfan_adine_ptest.entity.security.Permission;
import com.example.erfan_adine_ptest.exception.*;
import com.example.erfan_adine_ptest.repository.security.PermissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
@RequiredArgsConstructor
public class PermissionService {

    private final PermissionRepository permissionRepository;

    public PermissionOutDto save(PermissionInDto entity) throws NullFieldException, BadEntryException, NameNotValidException, EmailNotValidException, PasswordNotValidException, NullCommentException, NullAddresOfMainOrderException, NameOfSubServiceIsNull, BasePriceOfSubServiceIsNull, NameOfMainServiceIsNull, OrderOfRequestIsNullException, AddressOfRequestIsNull, RoleIsNullException, OrderOfTransactionIsNullExeption, SuggestionOfPriceIsNullException {

        Permission permission = new Permission();
        permission.setPermissionName(entity.getPermissionName());

        permissionRepository.save(permission);

        PermissionOutDto permissionOutDto = new PermissionOutDto();
        permissionOutDto.setPermissionName(permission.getPermissionName());
        permissionOutDto.setId(permission.getId());

        return permissionOutDto;
    }

    @Transactional
    public Permission findById(Long id) {
        return permissionRepository.findById(id).get();
    }



    @Transactional
    public List<Permission> findAll() {
        return permissionRepository.findAll();
    }

    @Transactional
    public void delete(Long id) {
        permissionRepository.delete(findById(id));
    }

    //***********************************************
    @Transactional
    public Permission findByPermissionName(String permissionName) {
        return permissionRepository.findByPermissionName(permissionName).get();
    }

}
