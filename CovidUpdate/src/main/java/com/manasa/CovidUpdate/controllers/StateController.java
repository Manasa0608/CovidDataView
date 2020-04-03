package com.manasa.CovidUpdate.controllers;

import com.manasa.CovidUpdate.model.District;
import com.manasa.CovidUpdate.model.State;
import com.manasa.CovidUpdate.repositories.StateRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/states")
public class StateController {

    @Autowired
    private StateRepository stateRepository;

    @GetMapping
    public List<State> list(){
        return stateRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public State get(@PathVariable Integer id){
        return stateRepository.getOne(id);
    }


    @RequestMapping(method = RequestMethod.POST)
    public State create(@RequestBody State state){
        return stateRepository.saveAndFlush(state);
    }

    @RequestMapping(value = "{id}",method = RequestMethod.PUT)
    public State update(@PathVariable Integer id, @RequestBody State state)
    {
        State existingState =stateRepository.getOne(id);
        BeanUtils.copyProperties(state,existingState,"state_id");
        return stateRepository.saveAndFlush(existingState);
    }

//      do not delete as districts are mapped to different districts
//    @RequestMapping(value = "{id}",method = RequestMethod.DELETE)
//    public void delete(@PathVariable Integer id){
//        stateRepository.deleteById(id);
//    }

}
