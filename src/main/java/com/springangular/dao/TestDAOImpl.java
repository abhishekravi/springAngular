package com.springangular.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.springangular.model.Test;


public class TestDAOImpl implements TestDAO{

	private static final Logger LOGGER = LoggerFactory.getLogger(TestDAOImpl.class);
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	
	@Override
	public List<Test> getAllRecords() {
		LOGGER.debug("getting all records");
		Session session = this.sessionFactory.getCurrentSession();
		List<Test> tests = session.createQuery("from test").list();
		return tests;
	}

	@Override
	public Test getRecordByID(long id) {
		LOGGER.debug("getting record by id");
		Session session = this.sessionFactory.getCurrentSession();
		Test t = session.load(Test.class, id);
		return t;
	}

	@Override
	public void insertRecord(Test t) {
		LOGGER.debug("inserting record");
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(t);
	}

	@Override
	public void deleteRecord(long id) {
		LOGGER.debug("deleting record");
		Session session = this.sessionFactory.getCurrentSession();
		Test t = session.load(Test.class, id);
		if(null != t){
			session.delete(t);
		}
	}

	@Override
	public void updateRecord(Test t) {
		LOGGER.debug("updating record");
		Session session = this.sessionFactory.getCurrentSession();
		session.update(t);
	}

}
