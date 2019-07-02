package com.sowing.seed.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sowing.seed.model.State;

@Repository
public interface IStateDao extends JpaRepository<State, Integer> {
	//public List<State> getAllStates();

	//public void createState(State state);


}
