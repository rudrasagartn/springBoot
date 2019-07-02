package com.sowing.seed.service;

import java.util.List;

import com.sowing.seed.model.State;

public interface IStateService {

	public void createState(State state);

	List<State> getAllStates();

	//public void save(State state);
}
