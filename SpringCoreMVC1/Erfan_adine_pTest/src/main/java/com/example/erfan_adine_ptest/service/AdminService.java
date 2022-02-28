package com.example.erfan_adine_ptest.service;


//fixme this import is very important because i can do some my works that ??????????????????????????????????


import com.example.erfan_adine_ptest.dto.core.BasePersonDto;
import com.example.erfan_adine_ptest.dto.in.user.AdminInDto;
import com.example.erfan_adine_ptest.dto.in.user.WorkerInDto;
import com.example.erfan_adine_ptest.dto.in.work.MainServiceInDto;
import com.example.erfan_adine_ptest.dto.out.BasPersonOutDto;
import com.example.erfan_adine_ptest.dto.out.user.AdminOutDto;
import com.example.erfan_adine_ptest.dto.out.user.WorkerOutDto;
import com.example.erfan_adine_ptest.dto.out.work.MainServiceOutDto;
import com.example.erfan_adine_ptest.entity.product.message.Request;
import com.example.erfan_adine_ptest.entity.security.Role;
import com.example.erfan_adine_ptest.entity.user.Admin;
import com.example.erfan_adine_ptest.entity.user.User;
import com.example.erfan_adine_ptest.entity.user.Worker;
import com.example.erfan_adine_ptest.entity.work.MainService;
import com.example.erfan_adine_ptest.entity.work.SubService;
import com.example.erfan_adine_ptest.exception.*;
import com.example.erfan_adine_ptest.repository.AdminRepository;
import com.example.erfan_adine_ptest.repository.CustomRequestRepository;
import com.example.erfan_adine_ptest.repository.DutyRepository;
//import com.example.erfan_adine_ptest.security.detail.CustomeAdminDetail;
import com.example.erfan_adine_ptest.service.util.Validation;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@RequiredArgsConstructor
public class AdminService implements CustomRequestRepository {

    private final AdminRepository adminRepository;
    private final WorkerService workerService;
    private final ExperteService experteService;
    private final DutyRepository dutyRepository;
    private PasswordEncoder passwordEncoder;

//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder(11);
//    }
////
//    public String changpass(String pass){
//        String encode = passwordEncoder().encode(pass);
//
//        return encode;
//    }

    public AdminOutDto saveAdmin(AdminInDto entity, String encode) {
//        Set<Role> roles = new HashSet<>();
//
//        for (String s : entity.getRole()) {
//            Role byRoleName = roleRepository.findByRoleName(s);
//            roles.add(byRoleName);
//        }


        //FIXME  HOW CAN SET   -->  PASSWORDENCODER ?🤔🤔
        Admin admin = new Admin();
//        admin.setPassword(encode(entity.getPassword()));
        admin.setPassword(encode);
        admin.setEmail(entity.getEmail());
        admin.setFName(entity.getFirstName());
        admin.setLName(entity.getLastName());
        admin.setUsername(entity.getUserName());
        admin.setRoles(entity.getRole());
        admin.setIsEnable(entity.getIsEnable());
        admin.setCreatedTime(new Date());
        admin.setUpdatedTime(new Date());

        adminRepository.save(admin);

        AdminOutDto response = new AdminOutDto();
        response.setId(admin.getId());

        return response;
    }



    @Transactional
    public BasPersonOutDto save(BasePersonDto request) {
        Admin admin =Admin.builder()
                .fName(request.getFirstName())
                .lName(request.getLastName())
                .password(passwordEncoder.encode(request.getPassword()))
                .username(request.getUsername())
                .email(request.getEmail())
                .roles(new HashSet<>(List.of(Role.ADMIN)))
                .build();
        Admin save = adminRepository.save(admin);
        return new BasPersonOutDto(save.getId());
    }

    public Admin findById(Long id) {
        return adminRepository.findById(id).get();
    }


    public List<Admin> findAll() {

        List<Admin> adminList = new ArrayList<>();
        adminRepository.findAll().forEach((element) -> adminList.add(element));

        return adminList;
    }


    public void updateAdminPassword(Long id, String password) {
        Admin a = findById(id);
        a.setPassword(password);
        adminRepository.save(a);
    }


    public void delete(Long id) {
        adminRepository.delete(findById(id));

    }


    // TODO f1 ------------------ > 1-3  service  false
    @Transactional
    public List<User> usersFiltering(String f) {
        return adminRepository.findByFName(f);
    }

    @Transactional
    public List<Worker> workersFiltering(String f, String l) {
        return adminRepository.findWorkerByName(f);
    }

    //-----------------------------------------------------


    @Transactional
    public WorkerOutDto addNewWorker(WorkerInDto workerInDto) throws NameNotValidException, EmailNotValidException, PasswordNotValidException, NullFieldException, BadEntryException {

        return workerService.save(workerInDto);

    }

    //-----------------------------------------------------------add new service and SubServiceInDto

    public SubService addNewSubService(SubService subService) throws NameNotValidException, NullFieldException, BadEntryException, EmailNotValidException, PasswordNotValidException, NullAddresOfMainOrderException, NameOfSubServiceIsNull, NullCommentException, BasePriceOfSubServiceIsNull, NameOfMainServiceIsNull, OrderOfRequestIsNullException, RoleIsNullException, AddressOfRequestIsNull, OrderOfTransactionIsNullExeption, SuggestionOfPriceIsNullException {

        return experteService.save(subService);


    }


    //-----------------------------------------------------------
    @Transactional
    public Worker findWorkerByName(String name) {
        return workerService.findByName(name);

    }

    @Transactional
    public SubService findExpertByName() {
        return null;
    }

    //fixme pleas fix this because I dont need these methods : ) :(
    //-----------------------------------------------------------add delete update  worker from service and subService


    //-------------------------------------------------------adding new  mainService and  expert
    //TODO f1 -------------------> 1-4 service True
    @Transactional
    public MainServiceOutDto addDuty(MainServiceInDto mainServiceInDto) {
        MainService mainService = new MainService();
        mainService.setName(mainServiceInDto.getName());
        mainService.setCreatedTime(new Date());
        mainService.setUpdatedTime(new Date());
        mainService.setDescription(mainServiceInDto.getDescription());
        dutyRepository.save(mainService);

        MainServiceOutDto result = new MainServiceOutDto();
        result.setId(mainService.getId());

        return result;


    }

    @Transactional
    public void addExpert(SubService subService) throws NullFieldException, BadEntryException, NameNotValidException, EmailNotValidException, PasswordNotValidException, NullAddresOfMainOrderException, NameOfSubServiceIsNull, NullCommentException, BasePriceOfSubServiceIsNull, NameOfMainServiceIsNull, OrderOfRequestIsNullException, RoleIsNullException, AddressOfRequestIsNull, OrderOfTransactionIsNullExeption, SuggestionOfPriceIsNullException {
        if (Validation.expertIsValid(subService)) {
            experteService.save(subService);
        }

    }

    @Override
    public List<Request> findByParameterMap(Map<String, String> parameterMap) {
        return null;
    }

    //--------------------------------------------
    //*************************
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//
//    }

//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Admin admin = adminRepository.findByUsername(username)
//                .orElseThrow(() -> new RuntimeException("not found user with username:" + username));
//
//        return new CustomeAdminDetail(admin);
//    }
}
