package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Income;

/**
 * 
 * @author hp
 *
 */
public interface IncomeService {

	public final static String ADD="ADD";
	public final static String EDIT="EDIT";
	public final static String DELETE="DELETE";
	public final static String GET_ALL="GET_ALL";
	
	public List<Income> doIncomeOpr(Income income,String actionName);
}
