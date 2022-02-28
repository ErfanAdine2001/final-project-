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
import com.example.erfan_adine_ptest.service.UserService;
import com.example.erfan_adine_ptest.service.WorkerService;
import lombok.*;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/manager")
public class AdminController {
    private final AdminService adminService;
    private final WorkerService workerService;
    private final MainService_Service mainServiceService;
    private  final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/create")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<AdminOutDto> create(@Valid @RequestBody AdminInDto request) throws NameOfSubServiceIsNull, NameOfMainServiceIsNull, SuggestionOfPriceIsNullException, NullCommentException, BasePriceOfSubServiceIsNull, NullFieldException, BadEntryException, AddressOfRequestIsNull, NullAddresOfMainOrderException, OrderOfTransactionIsNullExeption, OrderOfRequestIsNullException, NameNotValidException, EmailNotValidException, PasswordNotValidException, RoleIsNullException {

        String encode = passwordEncoder.encode(request.getPassword());

        AdminOutDto result = adminService.saveAdmin(request ,encode);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(result);

    }


    //Search Workers
    @PostMapping("/searchWorkerListByAllAttribute")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Page<WorkerOrUserSerchOutDto>> searchWorkers(@Valid @RequestBody WorkerOrUserSerchInDto request)  {


        Page<WorkerOrUserSerchOutDto> allByFNameAndLNameAndEmailAndPassword = workerService.findAllByFNameAndLNameAndEmailAndPassword(request);

        return ResponseEntity.status(HttpStatus.OK)
                .body(allByFNameAndLNameAndEmailAndPassword);



    }

    @PostMapping("/searchAllWorkerByFNameAndLName")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Page<WorkerOrUserSerchOutDto>> searchAllWorkerByFNameAndLName(@Valid @RequestBody WorkerOrUserSerchInDto request){


        Page<WorkerOrUserSerchOutDto> findAllByFNameAndLName = workerService.findAllByFNameAndLName(request);

        return ResponseEntity.status(HttpStatus.OK)
                .body(findAllByFNameAndLName);

// sletec * from User



    }
//*************/

    // search users
    @PostMapping("/search-worker-ListByAllAttribute2")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Page<WorkerOrUserSerchOutDto>> searchUsers(@Valid @RequestBody WorkerOrUserSerchInDto request){


        Page<WorkerOrUserSerchOutDto> allByFNameAndLNameAndEmailAndPassword = userService.findAllByFNameAndLNameAndEmailAndPassword(request);

        return ResponseEntity.status(HttpStatus.OK)
                .body(allByFNameAndLNameAndEmailAndPassword);




    }

    @PostMapping("/searchAllUserByFNameAndLName")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Page<WorkerOrUserSerchOutDto>> searchAllUserByFNameAndLName(@Valid @RequestBody WorkerOrUserSerchInDto request){


        Page<WorkerOrUserSerchOutDto> allByFNameAndLNameAndEmailAndPassword = userService.findAllByFNameAndLName(request);

        return ResponseEntity.status(HttpStatus.OK)
                .body(allByFNameAndLNameAndEmailAndPassword);




    }

    // add Main Service
    @PostMapping("/addMainService")
    @PreAuthorize("hasRole('ADMIN')")
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
    @PreAuthorize("hasRole('ADMIN')")
    public void AppointmentOfASpecialistToTheService(@Valid @RequestBody WorkerInDto workerInDto, @PathVariable("id") Long mainServiceId) throws NameNotValidException, EmailNotValidException, PasswordNotValidException, NullFieldException, NullAddresOfMainOrderException, OrderOfTransactionIsNullExeption, NameOfSubServiceIsNull, NameOfMainServiceIsNull, SuggestionOfPriceIsNullException, OrderOfRequestIsNullException, NullCommentException, BasePriceOfSubServiceIsNull, BadEntryException, RoleIsNullException, AddressOfRequestIsNull {
//        if (workerInDto.getMainServiceList() != null && workerInDto.getFirstName() != null) {
        if (isExistWork(workerInDto)) {
            WorkerOutDto workerOutDto = workerService.save(workerInDto);
            Worker w = workerService.findById(workerOutDto.getId());
//TOdO
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
//            return;
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
        //TODO+
        if (w.getId().equals(null))
            return true;
        return false;

//        if(w.getId() == workerInDto.getId() && w.getId().equals(null))
    }




}
