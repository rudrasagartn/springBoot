/*package com.sowing.seed.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sowing.seed.dao.ICityDao;
import com.sowing.seed.model.City;

@Transactional
@Repository
public class CityDaoImpl implements ICityDao {

	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<City> getAllCities() {
		String hql = "FROM City ";
		return (List<City>) entityManager.createQuery(hql).getResultList();
	}

}
*/