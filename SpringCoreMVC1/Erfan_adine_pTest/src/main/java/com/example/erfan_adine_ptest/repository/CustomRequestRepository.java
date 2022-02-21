package com.example.erfan_adine_ptest.repository;

import com.example.erfan_adine_ptest.entity.product.message.Request;

import java.util.List;
import java.util.Map;

public interface CustomRequestRepository {

    public List<Request> findByParameterMap(Map<String,String> parameterMap);
}
