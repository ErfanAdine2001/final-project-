package com.example.erfan_adine_ptest.service.security;

import com.example.erfan_adine_ptest.dto.in.product.message.RequestInDto;
import com.example.erfan_adine_ptest.dto.in.security.RoleInDto;
import com.example.erfan_adine_ptest.dto.out.product.message.RequestOutDto;
import com.example.erfan_adine_ptest.dto.out.security.RoleOutDto;
import com.example.erfan_adine_ptest.entity.product.message.Request;
import com.example.erfan_adine_ptest.entity.security.Permission;
import com.example.erfan_adine_ptest.entity.security.Role;
import com.example.erfan_adine_ptest.exception.*;
import com.example.erfan_adine_ptest.repository.security.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class RoleService {
    private final RoleRepository roleRepository;

    private final PermissionService permissionService;


    @Transactional
    public RoleOutDto save(RoleInDto entity) throws NullFieldException, BadEntryException, NameNotValidException, EmailNotValidException, PasswordNotValidException, NullCommentException, NullAddresOfMainOrderException, NameOfSubServiceIsNull, BasePriceOfSubServiceIsNull, NameOfMainServiceIsNull, OrderOfRequestIsNullException, AddressOfRequestIsNull, RoleIsNullException, OrderOfTransactionIsNullExeption, SuggestionOfPriceIsNullException {

        Set<Permission> permissions = new HashSet<>();

        for (String s : entity.getPermissionsName()) {
            Permission byPermissionName = permissionService.findByPermissionName(s);
            permissions.add(byPermissionName);
        }

        Role role = new Role();
        role.setRoleName(entity.getRoleName());
        role.setPermissions(permissions);

        roleRepository.save(role);

        RoleOutDto requestOutDto = new RoleOutDto();
        requestOutDto.setId(role.getId());

        return requestOutDto;
    }

    @Transactional
    public Role findById(Long id) {
        return roleRepository.findById(id).get();
    }

    @Transactional
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    @Transactional
    public void delete(Long id) {
        roleRepository.delete(findById(id));
    }
}
