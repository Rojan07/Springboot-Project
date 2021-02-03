package com.example.teacher.teacher.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "LIBRARY1")
public class Library {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "LIBRARYID")
	private int id;
	@Column(name = "LIBRARYNAME")
	private String name;

//	@ManyToMany
//	@JoinColumn(name = "tech_id")
//	private List<TeacherModel> teachermodel;

	public Library() {

	}

	public Library(int id, String name, List<TeacherModel> teachermodel) {
		super();
		this.id = id;
		this.name = name;
		// this.teachermodel = teachermodel;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

//	public List<TeacherModel> getTeachermodel() {
//		return teachermodel;
//	}
//
//	public void setTeachermodel(List<TeacherModel> teachermodel) {
//		this.teachermodel = teachermodel;
//	}

}

// @OneToMany
// private List<TeacherModel> teachermodel;

//@OneToOne
//@JoinColumn(name = "Tech_id")
