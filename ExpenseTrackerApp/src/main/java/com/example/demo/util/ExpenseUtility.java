/**
 * 
 */
package com.example.demo.util;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author hp
 *
 */
public class ExpenseUtility {
	
	public static String getMonthInString(Date date) {
		Calendar instance = Calendar.getInstance();
		instance.setTime(date);
		int month = instance.get(Calendar.MONTH);
		return getMonth(month);
	}
	
	public static String getMonth(int index) {
		List<String> monthList = Arrays.asList("Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sept","Oct","Nov","Dec");
		return monthList.get(index);
	}

}
