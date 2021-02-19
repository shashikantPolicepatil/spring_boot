package com.example.integration.demo.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class CachingServiceImpl {

	List<String> list;

	public void updateDataInMap(String message) {
		list = new ArrayList<String>();
		list.add(message);
	}

	public String getDataFromMap() {
		if (list == null)
			return "HI MY NAME IS PIYUSH-NULL";

		return list.get(0);
	}

}
