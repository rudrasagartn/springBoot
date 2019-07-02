package com.sowing.seed.service;

import java.util.List;

import com.sowing.seed.model.City;

public interface ICityService {

	public List<City> getAllCities();

	void createCity(City city);
}
