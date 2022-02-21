package com.example.erfan_adine_ptest.service;


//fixme this import is very important because i can do some my works that ??????????????????????????????????


import com.example.erfan_adine_ptest.dto.in.user.AdminInDto;
import com.example.erfan_adine_ptest.dto.in.user.WorkerInDto;
import com.example.erfan_adine_ptest.dto.in.work.MainServiceInDto;
import com.example.erfan_adine_ptest.dto.out.user.AdminOutDto;
import com.example.erfan_adine_ptest.dto.out.user.WorkerOutDto;
import com.example.erfan_adine_ptest.dto.out.work.MainServiceOutDto;
import com.example.erfan_adine_ptest.entity.product.message.Request;
import com.example.erfan_adine_ptest.entity.user.Admin;
import com.example.erfan_adine_ptest.entity.user.User;
import com.example.erfan_adine_ptest.entity.user.Worker;
import com.example.erfan_adine_ptest.entity.work.MainService;
import com.example.erfan_adine_ptest.entity.work.SubService;
import com.example.erfan_adine_ptest.exception.*;
import com.example.erfan_adine_ptest.repository.AdminRepository;
import com.example.erfan_adine_ptest.repository.CustomRequestRepository;
import com.example.erfan_adine_ptest.repository.DutyRepository;
import com.example.erfan_adine_ptest.service.util.Validation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static com.example.erfan_adine_ptest.service.util.Validation.checkBaseCustomerIsValid;


@Service
@RequiredArgsConstructor
public class AdminService  implements CustomRequestRepository {

    private final AdminRepository adminRepository;
    private final WorkerService workerService;
    private final ExperteService experteService;
    private final DutyRepository dutyRepository;


    public AdminOutDto saveAdmin(AdminInDto entity) throws NullFieldException, BadEntryException, NameNotValidException, EmailNotValidException, PasswordNotValidException, NullAddresOfMainOrderException, NameOfSubServiceIsNull, NameOfMainServiceIsNull, OrderOfRequestIsNullException, NullCommentException, BasePriceOfSubServiceIsNull, RoleIsNullException, AddressOfRequestIsNull, OrderOfTransactionIsNullExeption, SuggestionOfPriceIsNullException {
        Admin admin = new Admin();
        admin.setPassword(entity.getPassword());
        admin.setEmail(entity.getEmail());
        admin.setFName(entity.getFirstName());
        admin.setLName(entity.getLastName());
        admin.setRole(entity.getRole());
        adminRepository.save(admin);

        AdminOutDto response = new AdminOutDto();
        response.setId(admin.getId());

        return response;
    }




    public Admin findById(Long id) {
        return adminRepository.findById(id).get();
    }


    public List<Admin> findAll() {

        List<Admin> adminList = new ArrayList<>();
        adminRepository.findAll().forEach((element) -> adminList.add(element));

        return adminList;
    }


    public void updateAdminPassword(Long id,String password) throws NameNotValidException, NullFieldException, BadEntryException, EmailNotValidException, PasswordNotValidException, NullAddresOfMainOrderException, NameOfSubServiceIsNull, NameOfMainServiceIsNull, OrderOfRequestIsNullException, NullCommentException, BasePriceOfSubServiceIsNull, RoleIsNullException, AddressOfRequestIsNull, OrderOfTransactionIsNullExeption, SuggestionOfPriceIsNullException {
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
    //TODO f1 -------------> 1-1    Service
//    @Transactional
//    public User addNewCustomer(User user) throws NullFieldException, BadEntryException, NameNotValidException, EmailNotValidException, PasswordNotValidException, NullAddresOfMainOrderException, NameOfSubServiceIsNull, NameOfMainServiceIsNull, SuggestionOfPriceIsNullException, OrderOfRequestIsNullException, BasePriceOfSubServiceIsNull, AddressOfRequestIsNull {
//        if (checkBaseCustomerIsValid(user))
//            return userService.save(user);
//        return null;
//    }

    @Transactional
    public WorkerOutDto addNewWorker(WorkerInDto workerInDto) throws NameNotValidException, EmailNotValidException, PasswordNotValidException, NullFieldException, BadEntryException {

        return workerService.save(workerInDto);

    }

    //-----------------------------------------------------------add new service and SubServiceInDto
    //TODO f1 ----------> 1-4    Service
//    @Transactional
//    public void addNewService(MainService mainService) throws NameNotValidException, NullFieldException, BadEntryException, EmailNotValidException, PasswordNotValidException, NullAddresOfMainOrderException, NameOfSubServiceIsNull, NameOfMainServiceIsNull, OrderOfRequestIsNullException, NullCommentException, BasePriceOfSubServiceIsNull, RoleIsNullException, AddressOfRequestIsNull, OrderOfTransactionIsNullExeption, SuggestionOfPriceIsNullException {
//        if (validation.dutyIsValid(mainService)) {
//            mainServiceService.save(mainService);
//        }
//
//    }


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
    public MainServiceOutDto addDuty(MainServiceInDto mainServiceInDto) throws NullFieldException, BadEntryException, NameNotValidException, EmailNotValidException, PasswordNotValidException, NullAddresOfMainOrderException, NameOfSubServiceIsNull, NameOfMainServiceIsNull, OrderOfRequestIsNullException, NullCommentException, BasePriceOfSubServiceIsNull, RoleIsNullException, AddressOfRequestIsNull, OrderOfTransactionIsNullExeption, SuggestionOfPriceIsNullException {
        MainService mainService = new MainService();
        mainService.setName(mainServiceInDto.getName());
        mainService.setCreatedTime(new Date());
        mainService.setUpdatedTime(new Date());
        mainService.setDescription(mainServiceInDto.getDescription());
          dutyRepository.save(mainService);

        MainServiceOutDto result = new MainServiceOutDto() ;
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
}
