package com.data.model.istqb;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = { "optionA", "optionB", "optionC", "optionD", "optionE" })
public class Options {
	@XmlElement(name = "array")
	private Paragraph optionA;
	@XmlElement(name = "array")
	private Paragraph optionB;
	@XmlElement(name = "array")
	private Paragraph optionC;
	@XmlElement(name = "array")
	private Paragraph optionD;
	@XmlElement(name = "array")
	private Paragraph optionE;

	public Options() {
		super();
	}

	public Paragraph getOptionA() {
		return optionA;
	}

	public void setOptionA(Paragraph optionA) {
		this.optionA = optionA;
	}

	public Paragraph getOptionB() {
		return optionB;
	}

	public void setOptionB(Paragraph optionB) {
		this.optionB = optionB;
	}

	public Paragraph getOptionC() {
		return optionC;
	}

	public void setOptionC(Paragraph optionC) {
		this.optionC = optionC;
	}

	public Paragraph getOptionD() {
		return optionD;
	}

	public void setOptionD(Paragraph optionD) {
		this.optionD = optionD;
	}

	public Paragraph getOptionE() {
		return optionE;
	}

	public void setOptionE(Paragraph optionE) {
		this.optionE = optionE;
	}

}
