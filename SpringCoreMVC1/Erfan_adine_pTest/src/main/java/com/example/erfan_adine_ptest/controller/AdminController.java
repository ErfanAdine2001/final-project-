package com.example.erfan_adine_ptest.controller;

import com.example.erfan_adine_ptest.dto.in.user.AdminInDto;
import com.example.erfan_adine_ptest.dto.in.user.WorkerInDto;
import com.example.erfan_adine_ptest.dto.in.user.WorkerOrUserSerchInDto;
import com.example.erfan_adine_ptest.dto.in.work.MainServiceInDto;
import com.example.erfan_adine_ptest.dto.out.user.AdminOutDto;
import com.example.erfan_adine_ptest.dto.out.user.WorkerOrUserSerchOutDto;
import com.example.erfan_adine_ptest.dto.out.user.WorkerOutDto;
import com.example.erfan_adine_ptest.dto.out.work.MainServiceOutDto;
import com.example.erfan_adine_ptest.entity.user.Worker;
import com.example.erfan_adine_ptest.entity.work.MainService;
import com.example.erfan_adine_ptest.exception.*;
import com.example.erfan_adine_ptest.service.AdminService;
import com.example.erfan_adine_ptest.service.MainService_Service;
import com.example.erfan_adine_ptest.service.WorkerService;
import lombok.*;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/manager")
public class AdminController {
    private final AdminService adminService;
    private final MainService mainService;
    private final MainService_Service mainServiceService;
    private final UserController userController;
    private final WorkerController workderController;
    private final WorkerService workerService;


    @PostMapping
    public ResponseEntity<AdminOutDto> create(@Valid @RequestBody AdminInDto request) throws NameOfSubServiceIsNull, NameOfMainServiceIsNull, SuggestionOfPriceIsNullException, NullCommentException, BasePriceOfSubServiceIsNull, NullFieldException, BadEntryException, AddressOfRequestIsNull, NullAddresOfMainOrderException, OrderOfTransactionIsNullExeption, OrderOfRequestIsNullException, NameNotValidException, EmailNotValidException, PasswordNotValidException, RoleIsNullException {

        AdminOutDto result = adminService.saveAdmin(request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(result);

    }


    //Search Workers
    @PostMapping("/searchWorkerListByAllAttribute")
    public ResponseEntity<Page<WorkerOrUserSerchOutDto>> searchWorkers(@Valid @RequestBody WorkerOrUserSerchInDto request) throws NameOfSubServiceIsNull, NameOfMainServiceIsNull, SuggestionOfPriceIsNullException, NullCommentException, BasePriceOfSubServiceIsNull, NullFieldException, BadEntryException, AddressOfRequestIsNull, NullAddresOfMainOrderException, OrderOfTransactionIsNullExeption, OrderOfRequestIsNullException, NameNotValidException, EmailNotValidException, PasswordNotValidException, RoleIsNullException {
        ResponseEntity<Page<WorkerOrUserSerchOutDto>> result = workderController.findAllByFNameAndLNameAndEmailAndPassword(request);
        return result;

    }

    @PostMapping("/searchWorkerByFirstNameAndLastName")
    public ResponseEntity<Page<WorkerOrUserSerchOutDto>> searchAllWorkerByFNameAndLName(@Valid @RequestBody WorkerOrUserSerchInDto request) throws NameOfSubServiceIsNull, NameOfMainServiceIsNull, SuggestionOfPriceIsNullException, NullCommentException, BasePriceOfSubServiceIsNull, NullFieldException, BadEntryException, AddressOfRequestIsNull, NullAddresOfMainOrderException, OrderOfTransactionIsNullExeption, OrderOfRequestIsNullException, NameNotValidException, EmailNotValidException, PasswordNotValidException, RoleIsNullException {

        ResponseEntity<Page<WorkerOrUserSerchOutDto>> result = workderController.findAllByFNameAndLName(request);
        return result;

    }


    // search users
    @PostMapping("/searchWorkerListByAllAttribute")
    public ResponseEntity<Page<WorkerOrUserSerchOutDto>> searchUsers(@Valid @RequestBody WorkerOrUserSerchInDto request) throws NameOfSubServiceIsNull, NameOfMainServiceIsNull, SuggestionOfPriceIsNullException, NullCommentException, BasePriceOfSubServiceIsNull, NullFieldException, BadEntryException, AddressOfRequestIsNull, NullAddresOfMainOrderException, OrderOfTransactionIsNullExeption, OrderOfRequestIsNullException, NameNotValidException, EmailNotValidException, PasswordNotValidException, RoleIsNullException {
        ResponseEntity<Page<WorkerOrUserSerchOutDto>> result = userController.findAllByFNameAndLNameAndEmailAndPassword(request);
        return result;

    }

    @PostMapping("/searchWorkerByFirstNameAndLastName")
    public ResponseEntity<Page<WorkerOrUserSerchOutDto>> searchAllUserByFNameAndLName(@Valid @RequestBody WorkerOrUserSerchInDto request) throws NameOfSubServiceIsNull, NameOfMainServiceIsNull, SuggestionOfPriceIsNullException, NullCommentException, BasePriceOfSubServiceIsNull, NullFieldException, BadEntryException, AddressOfRequestIsNull, NullAddresOfMainOrderException, OrderOfTransactionIsNullExeption, OrderOfRequestIsNullException, NameNotValidException, EmailNotValidException, PasswordNotValidException, RoleIsNullException {

        ResponseEntity<Page<WorkerOrUserSerchOutDto>> result = userController.findAllByFNameAndLName(request);
        return result;

    }

    // add Main Service
    @PostMapping("/addMainService")
    public ResponseEntity<MainServiceOutDto> addMainService(@Valid @RequestBody MainServiceInDto mainServiceInDto) throws NameOfSubServiceIsNull, NameOfMainServiceIsNull, SuggestionOfPriceIsNullException, NullCommentException, BasePriceOfSubServiceIsNull, NullFieldException, BadEntryException, AddressOfRequestIsNull, NullAddresOfMainOrderException, OrderOfTransactionIsNullExeption, OrderOfRequestIsNullException, NameNotValidException, EmailNotValidException, PasswordNotValidException, RoleIsNullException {
        MainServiceOutDto result = mainServiceService.save(mainServiceInDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(result);

    }

    /**
     * <b>here we have to way :</b> <br>
     * 1) just set last name and find next add to main service <br>
     * 2) make a worker then save and then set to main service and save main service
     *
     * @param workerInDto
     */
    @PostMapping("/Appointment/toMainService/{id}")
    public void AppointmentOfASpecialistToTheService(@Valid @RequestBody WorkerInDto workerInDto, @PathVariable("id") Long mainServiceId) throws NameNotValidException, EmailNotValidException, PasswordNotValidException, NullFieldException, NullAddresOfMainOrderException, OrderOfTransactionIsNullExeption, NameOfSubServiceIsNull, NameOfMainServiceIsNull, SuggestionOfPriceIsNullException, OrderOfRequestIsNullException, NullCommentException, BasePriceOfSubServiceIsNull, BadEntryException, RoleIsNullException, AddressOfRequestIsNull {
//        if (workerInDto.getMainServiceList() != null && workerInDto.getFirstName() != null) {
        if (isExistWork(workerInDto)) {
            WorkerOutDto workerOutDto = workerService.save(workerInDto);
            Worker w = workerService.findById(workerOutDto.getId());

            Set<Worker> workerList = new HashSet<>();
            workerList.add(w);
            addNewWorkerToMainService(workerList, mainServiceId);
//
//            MainService mainService = mainServiceService.findById(MainServiceId);
//
//            MainServiceInDto mainServiceInDto = new MainServiceInDto();
//            mainServiceInDto.setId(mainService.getId());
//            mainServiceInDto.setWorkers(workerList);
//            mainServiceInDto.setName(mainService.getName());
//            mainServiceInDto.setUpdatedTime(new Date());
//            mainServiceService.save(mainServiceInDto);
            return;
        } else {

            String lastName = workerInDto.getLastName();
            Worker w = workerService.findByName(lastName);
            Set<Worker> workers = new HashSet<>();
            workers.add(w);
            addNewWorkerToMainService(workers, mainServiceId);


        }

    }

    public void addNewWorkerToMainService(Set<Worker> workers, Long mainServiceId) throws NameOfSubServiceIsNull, NameOfMainServiceIsNull, SuggestionOfPriceIsNullException, NullCommentException, BasePriceOfSubServiceIsNull, NullFieldException, BadEntryException, AddressOfRequestIsNull, NullAddresOfMainOrderException, OrderOfTransactionIsNullExeption, OrderOfRequestIsNullException, NameNotValidException, EmailNotValidException, PasswordNotValidException, RoleIsNullException {
        MainService mainService = mainServiceService.findById(mainServiceId);

        MainServiceInDto mainServiceInDto = new MainServiceInDto();
        mainServiceInDto.setId(mainService.getId());
        mainServiceInDto.setWorkers(workers);
        mainServiceInDto.setName(mainService.getName());
        mainServiceInDto.setUpdatedTime(new Date());
        mainServiceService.save(mainServiceInDto);
    }


    public boolean isExistWork(WorkerInDto workerInDto) {
        Worker w = workerService.findById(workerInDto.getId());
        if (w.getId().equals(null))
            return true;
        return false;

//        if(w.getId() == workerInDto.getId() && w.getId().equals(null))
    }




    //*****************************************


//
//    public ResponseEntity<?> changePassword(@RequestBody AdminInDto request ){
//
//
//
//
//    }


//
//    @GetMapping("/{id}")
//    public ResponseEntity<ContactDto> get(@PathVariable Integer id) {
//        Contact contact = contactService.get(id);
//
//        return ResponseEntity.ok(ContactDto.builder()
//                .id(contact.getId())
//                .name(contact.getName())
//                .email(contact.getEmail())
//                .build());
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<CreateContactResponse> put(@PathVariable Integer id, @RequestBody ContactDto contactDto) {
//        Contact newCon = contactService.get(id);
//        newCon.setAddress(contactDto.getAddress());
//        newCon.setEmail(contactDto.getEmail());
//        newCon.setTelephone(contactDto.getTelephone());
//        newCon.setName(contactDto.getName());
//
//
//        Contact result = contactService.update(newCon);
//
//        CreateContactResponse response = new CreateContactResponse();
//
//        response.setContactId(result.getId());
//
//        return ResponseEntity.status(HttpStatus.CREATED)
//                .body(response);
//
//        //------------
//
//
//
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<String> delete(@PathVariable Integer id) {
//        contactService.delete(id);
//
//        return ResponseEntity.ok(id+" deleted ");
//    }
}
