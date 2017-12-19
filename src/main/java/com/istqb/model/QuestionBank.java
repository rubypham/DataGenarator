package com.istqb.model;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class QuestionBank {
	private List<Session> session;

	public QuestionBank() {
		super();
		// TODO Auto-generated constructor stub
	}

	public QuestionBank(List<Session> session) {
		super();
		this.session = session;
	}

	public List<Session> getSession() {
		return session;
	}

	public void setSession(List<Session> session) {
		this.session = session;
	}

}
