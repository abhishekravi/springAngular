package com.springangular.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.springangular.model.Test;

/**
 * service implementation.
 * @author Abhishek Ravi Chandran
 *
 */
public class TestServicesImpl implements TestServices{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(TestServicesImpl.class);

	@Override
	public List<Test> getAllRecords() {
		LOGGER.debug("service getting records");
		return null;
	}

	@Override
	public Test getRecordByID(long id) {
		LOGGER.debug("service getting record by id");
		return null;
	}

	@Override
	public void saveRecord(Test t) {
		LOGGER.debug("service saving record");
	}

	@Override
	public void removeRecord(long id) {
		LOGGER.debug("service removing record by id");
	}

	@Override
	public void updateRecord(Test t) {
		LOGGER.debug("service updating record");
	}

}
