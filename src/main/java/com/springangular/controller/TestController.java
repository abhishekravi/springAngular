package com.springangular.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.springangular.model.Test;

/**
 * test rest controller to serve all test requests
 * @author Abhishek Ravi Chandran
 *
 */
@RestController
public class TestController {

	//logger for debugging
	private static final Logger LOGGER =
			LoggerFactory.getLogger(TestController.class);
	private static Map<Long, Test> map = new HashMap<Long, Test>();
	static{
		Test t = new Test(1, "asd");
		map.put(1l,t);
		t = new Test(2, "asd");
		map.put(2l,t);
	}

	/**
	 * method to get record by id.
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/api/test/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Test getRecordByID(@PathVariable("id") long id) {
		LOGGER.debug("in get by id");
		Test t = map.get(id);
		return t;
	}
	
	/**
	 * method to fetch all records.
	 * @return
	 */
	@RequestMapping(value = "api/test", method = RequestMethod.GET)
	@ResponseBody
	public List<Test> getRecords() {
		LOGGER.debug("in get");
		List<Test> tests = new ArrayList<Test>();
		for(Entry<Long, Test> t : map.entrySet())
			tests.add(t.getValue());
		LOGGER.debug(map.keySet().toString());
		return tests;
	}
	
	/**
	 * method to create a new record.
	 * @param t
	 */
	@RequestMapping(value = "api/test", method = RequestMethod.POST)
	@ResponseBody
	public void createRecord(@RequestBody Test t) {
		LOGGER.debug("in create");
		t.setId(getNextIndex());
		map.put(t.getId(), t);
	}
	
	/**
	 * method to delete a record by id.
	 * @param id
	 */
	@RequestMapping(value = "/api/test/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteRecord(@PathVariable("id") long id) {
		LOGGER.debug("in delete");
		map.remove(id);
	}
	
	/**
	 * method to get the next index.
	 * @return
	 */
	private long getNextIndex(){
		long m = 0;
		for(Long l : map.keySet()){
			if(l > m)
				m = l;
		}
		return m+1l;
	}
}
