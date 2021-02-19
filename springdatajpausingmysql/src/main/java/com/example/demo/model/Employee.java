/**
 * 
 */
package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author hp
 *
 */
@Entity(name = "TB_EMP")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Employee {

	public Employee(String fname) {
		this.fname = fname;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "fname")
	private String fname;
	
	
	
}
