package com.data.model.istqb;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "session" })
@XmlRootElement(name = "dict")
public class QuestionBank {
	private List<Session> session;

	public QuestionBank() {
		super();
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
