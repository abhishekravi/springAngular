package com.springangular.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springangular.dao.TestDAO;
import com.springangular.model.Test;

/**
 * service implementation.
 * @author Abhishek Ravi Chandran
 *
 */
@Service("testService")
public class TestServicesImpl implements TestServices{
	
	@Autowired
    private TestDAO dao;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(TestServicesImpl.class);

	@Override
	public List<Test> getAllRecords() {
		LOGGER.debug("service getting records");
		return dao.getAllRecords();
	}

	@Override
	public Test getRecordByID(long id) {
		LOGGER.debug("service getting record by id");
		return null;
	}

	@Override
	public void saveRecord(Test t) {
		LOGGER.debug("service saving record");
		dao.insertRecord(t);
	}

	@Override
	public void removeRecord(long id) {
		LOGGER.debug("service removing record by id");
		dao.deleteRecord(id);
	}

	@Override
	public void updateRecord(Test t) {
		LOGGER.debug("service updating record");
		dao.updateRecord(t);
	}

}
