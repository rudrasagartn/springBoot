package com.sowing.seed.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sowing.seed.dao.IStateDao;
import com.sowing.seed.model.State;
import com.sowing.seed.service.IStateService;

@Service
public class StateServiceImpl implements IStateService {

	@Autowired
	IStateDao stateDao;

	@Override
	public void createState(State state) {
		stateDao.save(state);
		
	}

	@Override
	public List<State> getAllStates() {
		return stateDao.findAll();
	}
	/*
	@Override
	public void createState(State state) {
		stateDao.createState(state);
	}

	@Override
	public void save(State state) {
		stateDao.save(state);
		
	}*/

}
