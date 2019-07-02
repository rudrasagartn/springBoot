package com.sowing.seed.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sowing.seed.model.State;

@Transactional
@Repository
public abstract class StateDaoImpl {

	@PersistenceContext
	private EntityManager entityManager;

	@Autowired

	@SuppressWarnings("unchecked")
	public List<State> getAllStates() {
		String hql = "FROM State ";
		return (List<State>) entityManager.createQuery(hql).getResultList();
	}

}
