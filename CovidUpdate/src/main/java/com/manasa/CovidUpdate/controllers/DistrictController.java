package com.manasa.CovidUpdate.controllers;

import com.manasa.CovidUpdate.model.District;
import com.manasa.CovidUpdate.model.State;
import com.manasa.CovidUpdate.repositories.DistrictRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/districts")
public class DistrictController {

    @Autowired
    private DistrictRepository districtRepository;

    @GetMapping
    public List<District> list() {
        return districtRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public District get(@PathVariable Integer id){
        return districtRepository.getOne(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public District create(@RequestBody District district){
        return districtRepository.saveAndFlush(district);
    }

    @RequestMapping(value = "{id}",method = RequestMethod.PUT)
    public District update(@PathVariable Integer id, @RequestBody District district)
    {
        District existingDistrict =districtRepository.getOne(id);
        BeanUtils.copyProperties(district,existingDistrict,"district_id");
        return districtRepository.saveAndFlush(existingDistrict);
    }

    @RequestMapping(value = "{id}",method = RequestMethod.DELETE)
    public void delete(@PathVariable Integer id){
        districtRepository.deleteById(id);
    }
}

