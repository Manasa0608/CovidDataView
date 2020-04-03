package com.manasa.CovidUpdate.repositories;

import com.manasa.CovidUpdate.model.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StateRepository extends JpaRepository<State, Integer> {
}
