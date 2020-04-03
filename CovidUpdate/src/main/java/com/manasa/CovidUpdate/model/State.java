package com.manasa.CovidUpdate.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "states")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class State {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer state_id;
    private String state_name;

    @OneToMany(mappedBy = "states")
    @JsonIgnore
    private List<District> districts;

    public State() {
    }

    public Integer getState_id() {
        return state_id;
    }

    public void setState_id(Integer state_id) {
        this.state_id = state_id;
    }

    public String getState_name() {
        return state_name;
    }

    public List<District> getDistricts() {
        return districts;
    }

    public void setDistricts(List<District> districts) {
        this.districts = districts;
    }

    public void setState_name(String state_name) {
        this.state_name = state_name;
    }


}
