package com.sowing.seed.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sowing.seed.model.City;

public interface ICityDao extends JpaRepository<City, Integer> {

}
