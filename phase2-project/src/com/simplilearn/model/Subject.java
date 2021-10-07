package com.simplilearn.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Subject Table")

public class Subject {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="SubjectName")
	private String SubjectName;

	public Subject(int id, String subjectName) {
		super();
		this.id = id;
		SubjectName = subjectName;
	}
	

	public Subject(String subjectName) {
		super();
		SubjectName = subjectName;
	}


	public Subject() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSubjectName() {
		return SubjectName;
	}

	public void setSubjectName(String subjectName) {
		SubjectName = subjectName;
	}

	@Override
	public String toString() {
		return "Subject [id=" + id + ", SubjectName=" + SubjectName + "]";
	}
	
	
	
	

}
