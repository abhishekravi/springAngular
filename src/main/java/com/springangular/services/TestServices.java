package com.springangular.services;

import java.util.List;

import com.springangular.model.Test;


public interface TestServices {

	public List<Test> getAllRecords();
	public Test getRecordByID(long id);
	public void saveRecord(Test t);
	public void removeRecord(long id);
	public void updateRecord(Test t);
}
