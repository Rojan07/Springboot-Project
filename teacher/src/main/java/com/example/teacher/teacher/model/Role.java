package com.example.teacher.teacher.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Role {

	@Id
	@GeneratedValue
	private int roleid;
	private String role;

	public int getRoleid() {
		return roleid;
	}

	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	public Role() {
		
		
	}

	public Role(int roleid, String role) {
		super();
		this.roleid = roleid;
		this.role = role;
	}

}
