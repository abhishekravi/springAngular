package com.springangular.services;

import java.util.List;

import com.springangular.model.Test;

/**
 * service interface.
 * @author Abhishek Ravi Chandran
 *
 */
public interface TestServices {

	public List<Test> getAllRecords();
	public Test getRecordByID(long id);
	public void saveRecord(Test t);
	public void removeRecord(long id);
	public void updateRecord(Test t);
}
