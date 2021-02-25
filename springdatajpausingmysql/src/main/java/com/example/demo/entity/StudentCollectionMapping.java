/**
 * 
 */
package com.example.demo.entity;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import javax.persistence.OrderColumn;

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
@Entity(name = "tb_student_mapping")
public class StudentCollectionMapping {
	
	public StudentCollectionMapping(String sname,Set<String> subjects,List<Integer> marks,Map<String,String> lExams) {
		this.sName = sname;
		this.subjects = subjects;
		this.marks = marks;
		this.labExams = lExams;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer sId;
	
	@Column(name = "name")
	private String sName;
	
	@ElementCollection
	@CollectionTable(name = "std_subjects",joinColumns = @JoinColumn(name="sId"))
	@Column(name="subject")
	Set<String> subjects;
	
	
	@ElementCollection
	@Column(name="marks")
	@CollectionTable(name="std_marks",joinColumns = @JoinColumn(name="sId"))
	@OrderColumn(name="position")
	List<Integer> marks;
	
	
	@ElementCollection
	@Column(name="grade")
	@CollectionTable(name="std_lab",joinColumns = @JoinColumn(name="sId"))
	@MapKeyColumn(name="labName")
	Map<String,String> labExams;	
}
