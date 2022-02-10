package com.example.erfan_adine_ptest.service;


import com.example.erfan_adine_ptest.entity.work.SubService;
import com.example.erfan_adine_ptest.repository.ExperteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SubService_Service {

    private final ExperteRepository experteRepository;


    public List<SubService> showSubServices(){
        List<SubService> subServiceList = new ArrayList<>();
        Iterable<SubService> result = experteRepository.findAll();
        result.forEach((element) -> subServiceList.add(element));

        return subServiceList;
    }

    public SubService save(SubService subService){
     return experteRepository.save(subService);
    }


    public SubService findById(Long id){
        return experteRepository.findById(id).get();
    }

//    public


}
