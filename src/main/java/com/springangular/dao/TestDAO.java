package com.springangular.dao;

import java.util.List;

import com.springangular.model.Test;


public interface TestDAO {

	public List<Test> getAllRecords();
	public Test getRecordByID(long id);
	public void insertRecord(Test t);
	public void deleteRecord(long id);
	public void updateRecord(Test t);
}
