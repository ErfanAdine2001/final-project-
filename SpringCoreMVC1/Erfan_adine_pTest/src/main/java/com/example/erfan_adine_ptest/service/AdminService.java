package com.example.erfan_adine_ptest.service;


//fixme this import is very important because i can do some my works that ??????????????????????????????????


import com.example.erfan_adine_ptest.entity.user.Admin;
import com.example.erfan_adine_ptest.entity.user.User;
import com.example.erfan_adine_ptest.entity.user.Worker;
import com.example.erfan_adine_ptest.entity.work.MainService;
import com.example.erfan_adine_ptest.entity.work.SubService;
import com.example.erfan_adine_ptest.exception.*;
import com.example.erfan_adine_ptest.repository.AdminRepository;
import com.example.erfan_adine_ptest.service.util.Validation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.List;

import static com.example.erfan_adine_ptest.service.util.Validation.checkBaseCustomerIsValid;


@Service
@RequiredArgsConstructor
public class AdminService extends Common<Admin, Long> {

    private final AdminRepository adminRepository;

    private final UserService userService;
    private final WorkerService workerService;
    private final MainService_Service mainServiceService;
    private final ExperteService experteService;
    private Validation validation;

    @PostConstruct
    public void init() {
        setJpaRepository(adminRepository);
    }



    /**
     * duty : "save"
     *
     * @param entity
     * @return
     * @throws NullFieldException
     * @throws BadEntryException
     * @throws NameNotValidException
     * @throws EmailNotValidException
     * @throws PasswordNotValidException
     */
    @Override
    public Admin save(Admin entity) throws NullFieldException, BadEntryException, NameNotValidException, EmailNotValidException, PasswordNotValidException, NullAddresOfMainOrderException, NameOfSubServiceIsNull, NameOfMainServiceIsNull, OrderOfRequestIsNullException, NullCommentException, BasePriceOfSubServiceIsNull, RoleIsNullException, AddressOfRequestIsNull, OrderOfTransactionIsNullExeption, SuggestionOfPriceIsNullException {
        if (checkBaseCustomerIsValid(entity)) {
            return super.save(entity);
        }
        return null;
    }

    /**
     * duty : "find By Id"
     *
     * @param id
     * @return AdminInDto
     */

    @Override
    public Admin findById(Long id) {
        return super.findById(id);
    }

    /**
     * duty : "find All"
     *
     * @return
     */
    @Override
    public List<Admin> findAll() {
        return super.findAll();
    }

    /**
     * duty : " update"
     *
     * @param id
     * @throws NameNotValidException
     * @throws NullFieldException
     * @throws BadEntryException
     * @throws EmailNotValidException
     * @throws PasswordNotValidException
     */
    @Override
    public void update(Long id) throws NameNotValidException, NullFieldException, BadEntryException, EmailNotValidException, PasswordNotValidException, NullAddresOfMainOrderException, NameOfSubServiceIsNull, NameOfMainServiceIsNull, OrderOfRequestIsNullException, NullCommentException, BasePriceOfSubServiceIsNull, RoleIsNullException, AddressOfRequestIsNull, OrderOfTransactionIsNullExeption, SuggestionOfPriceIsNullException {
        super.update(id);
    }

    /**
     * duty : " delete "
     *
     * @param id
     */
    @Override
    public void delete(Long id) {
        super.delete(id);
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
    @Transactional
    public User addNewCustomer(User user) throws NullFieldException, BadEntryException, NameNotValidException, EmailNotValidException, PasswordNotValidException, NullAddresOfMainOrderException, NameOfSubServiceIsNull, NameOfMainServiceIsNull, SuggestionOfPriceIsNullException, OrderOfRequestIsNullException, BasePriceOfSubServiceIsNull, AddressOfRequestIsNull {
        if (checkBaseCustomerIsValid(user))
            return userService.save(user);
        return null;
    }

    @Transactional
    public Worker addNewWorker(Worker worker) throws NameNotValidException, EmailNotValidException, PasswordNotValidException, NullFieldException, BadEntryException {

            return workerService.save(worker);


    }

    //-----------------------------------------------------------add new service and SubServiceInDto
    //TODO f1 ----------> 1-4    Service
    @Transactional
    public void addNewService(MainService mainService) throws NameNotValidException, NullFieldException, BadEntryException, EmailNotValidException, PasswordNotValidException, NullAddresOfMainOrderException, NameOfSubServiceIsNull, NameOfMainServiceIsNull, OrderOfRequestIsNullException, NullCommentException, BasePriceOfSubServiceIsNull, RoleIsNullException, AddressOfRequestIsNull, OrderOfTransactionIsNullExeption, SuggestionOfPriceIsNullException {
        if (validation.dutyIsValid(mainService)) {
            mainServiceService.save(mainService);
        }

    }


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
    public void addDuty(MainService mainService) throws NullFieldException, BadEntryException, NameNotValidException, EmailNotValidException, PasswordNotValidException, NullAddresOfMainOrderException, NameOfSubServiceIsNull, NameOfMainServiceIsNull, OrderOfRequestIsNullException, NullCommentException, BasePriceOfSubServiceIsNull, RoleIsNullException, AddressOfRequestIsNull, OrderOfTransactionIsNullExeption, SuggestionOfPriceIsNullException {
        if (Validation.dutyIsValid(mainService)) {
            mainServiceService.save(mainService);
        }
    }

    @Transactional
    public void addExpert(SubService subService) throws NullFieldException, BadEntryException, NameNotValidException, EmailNotValidException, PasswordNotValidException, NullAddresOfMainOrderException, NameOfSubServiceIsNull, NullCommentException, BasePriceOfSubServiceIsNull, NameOfMainServiceIsNull, OrderOfRequestIsNullException, RoleIsNullException, AddressOfRequestIsNull, OrderOfTransactionIsNullExeption, SuggestionOfPriceIsNullException {
        if (Validation.expertIsValid(subService)) {
            experteService.save(subService);
        }

    }

    //--------------------------------------------
}
