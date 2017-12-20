package com.data.model.istqb;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = { "string", "integer" })
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
