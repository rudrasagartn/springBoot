package com.sowing.seed.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sowing.seed.dao.ICityDao;
import com.sowing.seed.model.City;
import com.sowing.seed.service.ICityService;

@Service
public class CityServiceImpl implements ICityService {

	@Autowired
	ICityDao iCityDao;

	@Override
	public List<City> getAllCities() {
		return iCityDao.findAll();
	}
	
	@Override
	public void createCity(City city){
		iCityDao.save(city);
	}

}
