package com.example.erfan_adine_ptest.service;

import com.example.erfan_adine_ptest.dto.in.product.CommentInDto;
import com.example.erfan_adine_ptest.dto.out.product.CommentOutDto;
import com.example.erfan_adine_ptest.entity.product.Comment;
import com.example.erfan_adine_ptest.entity.work.SubService;
import com.example.erfan_adine_ptest.exception.*;
import com.example.erfan_adine_ptest.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;


@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final MainOrderService mainOrderService;
    private final UserService userService;
    private final SubService_Service subServiceService;

    @Transactional
    public Comment findById(Long id) {
        return commentRepository.findById(id).get();
    }

    @Transactional
    public List<Comment> findAll() {
        return commentRepository.findAll();
    }

    @Transactional
    public CommentOutDto save(CommentInDto commentInDto) throws NullFieldException, BadEntryException, NameNotValidException, EmailNotValidException, PasswordNotValidException, NullCommentException, NullAddresOfMainOrderException, NameOfSubServiceIsNull, NameOfMainServiceIsNull, OrderOfRequestIsNullException, BasePriceOfSubServiceIsNull, RoleIsNullException, AddressOfRequestIsNull, OrderOfTransactionIsNullExeption, SuggestionOfPriceIsNullException {


        Comment comment = new Comment();
        comment.setPoints(commentInDto.getPoints());
        comment.setDescription(commentInDto.getDescription());
        comment.setOrder(mainOrderService.findById(commentInDto.getMainOrderId()));
        comment.setCreatedTime(new Date());
        comment.setUpdatedTime(new Date());
        comment.setUser(userService.findById(commentInDto.getUserId()));
        comment.setSubService(subServiceService.findById(commentInDto.getSubServiceId()));

         commentRepository.save(comment);

        CommentOutDto commentOutDto = new CommentOutDto();
        commentOutDto.setId(comment.getId());
        return commentOutDto;
    }

    @Transactional
    public void delete(Long id) {
        commentRepository.delete(findById(id));
    }

    @Transactional
    public void update(Long id, String Description, Integer point) throws NameNotValidException, NullFieldException, BadEntryException, EmailNotValidException, PasswordNotValidException, NullAddresOfMainOrderException, NameOfSubServiceIsNull, NameOfMainServiceIsNull, OrderOfRequestIsNullException, NullCommentException, BasePriceOfSubServiceIsNull, RoleIsNullException, AddressOfRequestIsNull, OrderOfTransactionIsNullExeption, SuggestionOfPriceIsNullException {

        Comment comment = findById(id);
        comment.setDescription(Description);
        comment.setPoints(point);

        commentRepository.save(comment);
    }


}
