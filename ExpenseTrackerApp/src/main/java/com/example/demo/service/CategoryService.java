/**
 * 
 */
package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.ExpenseCategory;

/**
 * @author hp
 *
 */
public interface CategoryService {

	public final static String ADD="ADD";
	public final static String EDIT="EDIT";
	public final static String DELETE="DELETE";
	public final static String GET_ALL="GELL_ALL";
	
	public List<ExpenseCategory> doCategoryOpr(ExpenseCategory expenseCategory,String actionName);
}
