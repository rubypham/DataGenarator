package com.istqb.model;

import java.util.List;

public class Paragraph {
	private List<String> string;
	private List<Integer> integer;

	public Paragraph() {
		super();
	}

	public List<String> getString() {
		return string;
	}

	public void setString(List<String> string) {
		this.string = string;
	}

	public List<Integer> getInteger() {
		return integer;
	}

	public void setInteger(List<Integer> integer) {
		this.integer = integer;
	}

}
