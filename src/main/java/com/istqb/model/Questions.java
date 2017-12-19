package com.istqb.model;

import java.util.List;

public class Questions {
	private List<Question> dict;

	public Questions() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Questions(List<Question> dict) {
		super();
		this.dict = dict;
	}

	public List<Question> getDict() {
		return dict;
	}

	public void setDict(List<Question> dict) {
		this.dict = dict;
	}

}
