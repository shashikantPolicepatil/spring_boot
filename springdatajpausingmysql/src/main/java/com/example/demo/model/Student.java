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

@Entity(name = "TB_Student")
@Data
@NoArgsConstructor 
@AllArgsConstructor
@ToString
public class Student {
	
	public Student(String sName, Integer sFee) {
		this.sName = sName;
		this.sFee = sFee;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer sId;
	
	@Column(name="name")
	private String sName;
	
	@Column(name="fees")
	private Integer sFee;

}
