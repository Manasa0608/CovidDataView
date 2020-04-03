package com.manasa.CovidUpdate.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "districts")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class District {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer district_id;

    private String district_name;
    private Integer district_affected_count;

    @ManyToOne
    @JoinColumn(name = "state_id")
    private State states;

    public State getState() {
        return states;
    }

    public void setState(State states) {
        this.states = states;
    }

    public Integer getDistrict_id() {
        return district_id;
    }

    public void setDistrict_id(Integer district_id) {
        this.district_id = district_id;
    }

    public String getDistrict_name() {
        return district_name;
    }

    public void setDistrict_name(String district_name) {
        this.district_name = district_name;
    }

    public Integer getDistrict_affected_count() {
        return district_affected_count;
    }

    public void setDistrict_affected_count(Integer district_affected_count) {
        this.district_affected_count = district_affected_count;
    }



    public District() {
    }
}
