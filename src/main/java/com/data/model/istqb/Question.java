package com.data.model.istqb;

import java.beans.Transient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = { "idKey", "id", "levelKey", "level", "rootKey", "root", "optionsKey", "options", "rightKey",
		"right", "explanationKey", "explanation" })
public class Question {

	@XmlElement(name = "key")
	private String idKey = "id";
	@XmlElement(name = "string")
	private String id;

	private transient String sessionId;

	@XmlElement(name = "key")
	private String levelKey = "level";
	@XmlElement(name = "string")
	private int level;

	@XmlElement(name = "key")
	private String rootKey = "root";
	@XmlElement(name = "array")
	private Paragraph root;

	@XmlElement(name = "key")
	private String optionsKey = "options";
	private Options options;

	@XmlElement(name = "key")
	private String rightKey = "right";
	private Paragraph right;

	@XmlElement(name = "key")
	private String explanationKey = "explanation";
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

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
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

	public String getIdKey() {
		return idKey;
	}

	public String getLevelKey() {
		return levelKey;
	}

	public String getRootKey() {
		return rootKey;
	}

	public String getOptionsKey() {
		return optionsKey;
	}

	public String getRightKey() {
		return rightKey;
	}

	public String getExplanationKey() {
		return explanationKey;
	}

}
