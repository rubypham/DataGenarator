package com.data.model.istqb;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType( propOrder = { "dict" })
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
