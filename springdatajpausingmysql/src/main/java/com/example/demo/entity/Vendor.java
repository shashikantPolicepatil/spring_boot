/**
 * 
 */
package com.example.demo.entity;

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
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Vendor {
	
	
	@Id
	@Column(name="vid_col")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer vid;
	
	@Column(name="vcode_col")
	private String vcode;
	
	@Column(name="vloc_col")
	private String vloc;
	
	public Vendor(String vcode,String vloc) {
		this.vcode = vcode;
		this.vloc = vloc;
	}
	
}
