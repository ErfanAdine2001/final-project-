package com.example.erfan_adine_ptest.controller;
import com.example.erfan_adine_ptest.dto.in.user.AdminInDto;
import com.example.erfan_adine_ptest.dto.out.user.AdminOutDto;
import com.example.erfan_adine_ptest.entity.user.Admin;
import com.example.erfan_adine_ptest.exception.*;
import com.example.erfan_adine_ptest.service.AdminService;
import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequiredArgsConstructor
@RequestMapping("/admins")
public class AdminController {
    private final AdminService adminService;

    @PostMapping
    public ResponseEntity<AdminOutDto> create(@Valid @RequestBody AdminInDto request) throws NameOfSubServiceIsNull, NameOfMainServiceIsNull, SuggestionOfPriceIsNullException, NullCommentException, BasePriceOfSubServiceIsNull, NullFieldException, BadEntryException, AddressOfRequestIsNull, NullAddresOfMainOrderException, OrderOfTransactionIsNullExeption, OrderOfRequestIsNullException, NameNotValidException, EmailNotValidException, PasswordNotValidException, RoleIsNullException {

        Admin admin = new Admin();
        admin.setFName(request.getFirstName());
        admin.setLName(request.getLastName());
        admin.setEmail(request.getEmail());
        admin.setPassword(request.getPassword());
//        admin.setImage(request.getImage());

        Admin result = adminService.save(admin);
        AdminOutDto response = new AdminOutDto();

        response.setId(result.getId());

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(response);

    }


//    public ResponseEntity<?> changePassword(){
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
