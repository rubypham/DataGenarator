package com.nfl.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NflData {
	private Scores scores;

	public NflData() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NflData(Scores scores) {
		super();
		this.scores = scores;
	}

	@JsonProperty("Scores")
	public Scores getScores() {
		return scores;
	}

	public void setScores(Scores scores) {
		this.scores = scores;
	}

}
