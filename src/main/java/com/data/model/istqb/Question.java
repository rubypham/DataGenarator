package com.data.model.istqb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType( propOrder = {"sessionId", "id", "level", "root", "options", "right", "explanation" })
public class Question {
	private String sessionId;
	private String id;
	private String level;
	private Paragraph root;
	private Options options;
	private Paragraph right;
	private Paragraph explanation;

	public Question() {
		super();
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public Paragraph getRoot() {
		return root;
	}

	public void setRoot(Paragraph root) {
		this.root = root;
	}

	public Options getOptions() {
		return options;
	}

	public void setOptions(Options options) {
		this.options = options;
	}

	public Paragraph getRight() {
		return right;
	}

	public void setRight(Paragraph right) {
		this.right = right;
	}

	public Paragraph getExplanation() {
		return explanation;
	}

	public void setExplanation(Paragraph explanation) {
		this.explanation = explanation;
	}

}
