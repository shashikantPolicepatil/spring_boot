package com.example.demo.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
	
	@Override
	public Map<String,Object> getAllCategory(ExpenseCategory expenseCategory) {
		Pageable pageable = PageRequest.of(expenseCategory.getId(), 5,Sort.by("categoryDesc"));
		Page<ExpenseCategory> allCateList = categoryRepository.findAll(pageable);
		
		Map<String,Object> response = new HashMap<String,Object>();
		response.put("cateList", allCateList.getContent());
		response.put("pages", allCateList.getTotalPages());
		response.put("size", allCateList.getTotalElements());
		response.put("currentPage", allCateList.getNumber());
		return response;
	}
	
	

}
