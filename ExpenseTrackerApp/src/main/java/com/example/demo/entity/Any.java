/**
 * 
 */
package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author hp
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Any {

	private String field;
	private Double value;
	
	private Double per;
	
}
