package com.simplilearn.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Class_Schedule_tableS")

public class ClassShedule {
	
	// properties
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
		@Column(name="class_section")
	private String section;
	
	
	public ClassShedule(String section) {
			super();
			this.section = section;
		}
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="id")
	private Subject subject;



	public ClassShedule(int id, String section) {
			super();
			this.id = id;
			this.section = section;
		}



	public ClassShedule() {
		super();
	}



	

	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getSection() {
		return section;
	}


	





	


	public Subject getSubject() {
		return subject;
	}



	@Override
	public String toString() {
		return "ClassShedule [id=" + id + ", section=" + section + "]";
	}



	public void setSubject(Subject sub) {
		// TODO Auto-generated method stub
		
	}


	
	
	
	

}
