package com.example.teacher.teacher.model;

import java.io.Serializable;

public class JwtResponse implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String jwttoken;

	public String getJwttoken() {
		return jwttoken;
	}

	public void setJwttoken(String jwttoken) {
		this.jwttoken = jwttoken;
	}

	public JwtResponse() {
	}

	public JwtResponse(String jwttoken) {

		this.jwttoken = jwttoken;
	}

}



