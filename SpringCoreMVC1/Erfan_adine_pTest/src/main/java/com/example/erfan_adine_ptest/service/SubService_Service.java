package com.example.erfan_adine_ptest.service;


import com.example.erfan_adine_ptest.dto.in.work.SubServiceInDto;
import com.example.erfan_adine_ptest.dto.out.work.SubServiceOutDto;
import com.example.erfan_adine_ptest.entity.work.MainService;
import com.example.erfan_adine_ptest.entity.work.SubService;
import com.example.erfan_adine_ptest.repository.DutyRepository;
import com.example.erfan_adine_ptest.repository.ExperteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SubService_Service {

    private final ExperteRepository experteRepository;
    private final DutyRepository dutyRepository;


    public List<SubService> showSubServices() {
        List<SubService> subServiceList = new ArrayList<>();
        Iterable<SubService> result = experteRepository.findAll();
        result.forEach((element) -> subServiceList.add(element));

        return subServiceList;
    }


    public SubServiceOutDto save(SubServiceInDto subService) {
        List<MainService> mainServiceList = new ArrayList<>();
        for (Long configurer : subService.getMainServiceId()) {

            MainService mainService = dutyRepository.findById(configurer).get();
            mainServiceList.add(mainService);
        }

        SubService service = new SubService();
        service.setName(subService.getName());
        service.setMainService(mainServiceList);
        service.setBasePrice(subService.getBasePrice());

        experteRepository.save(service);

        SubServiceOutDto subServiceOutDto = new SubServiceOutDto();
        subServiceOutDto.setId(service.getId());

        return subServiceOutDto;
    }


    public SubService save(SubService subService) {
        return experteRepository.save(subService);
    }


    public SubService findById(Long id) {
        return experteRepository.findById(id).get();
    }

    public List<SubService> findAll() {

        return experteRepository.findAll();
    }

    public void delete(Long id) {
        experteRepository.delete(findById(id));
    }

//    public


}
