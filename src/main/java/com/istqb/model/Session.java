package com.istqb.model;

public class Session {
	private String key;
	private Questions array;

	public Session() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Session(String key, Questions array) {
		super();
		this.key = key;
		this.array = array;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public Questions getArray() {
		return array;
	}

	public void setArray(Questions array) {
		this.array = array;
	}

}
