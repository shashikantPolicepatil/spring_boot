package com.example.demo.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.entity.ExpenseCategory;
import com.example.demo.repository.ExpenseCategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService{

	private ExpenseCategoryRepository categoryRepository;
	
	@Autowired
	public CategoryServiceImpl(ExpenseCategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}
	
	@Override
	public List<ExpenseCategory> doCategoryOpr(ExpenseCategory expenseCategory,String actionName) {
		switch(actionName) {
		case ADD:
			expenseCategory.setCategoryCode(expenseCategory.getCategoryDesc().toUpperCase());
			return Arrays.asList(categoryRepository.save(expenseCategory));
		case EDIT:
			return Arrays.asList(categoryRepository.save(expenseCategory));
		case DELETE:
			categoryRepository.delete(expenseCategory);
			return Arrays.asList(expenseCategory);
		case GET_ALL:
			Sort byName = Sort.by("categoryDesc");
			return categoryRepository.findAll(byName);
			
			default:return Arrays.asList(expenseCategory);
		}
		
	}
	
	

}
