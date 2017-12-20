package com.data.model.nfl;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.fasterxml.jackson.databind.node.BaseJsonNode;

public class Scores {
	private List<GameSnapShot> gameSnapShot;
	private int _refresh;

	public Scores() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Scores(List<GameSnapShot> gameSnapShot, int _refresh) {
		super();
		this.gameSnapShot = gameSnapShot;
		this._refresh = _refresh;
	}

	@JsonProperty("GameSnapShot")
	public List<GameSnapShot> getGameSnapShot() {
		return gameSnapShot;
	}

	public void setGameSnapShot(List<GameSnapShot> gameSnapShot) {
		this.gameSnapShot = gameSnapShot;
	}

	public int get_refresh() {
		return _refresh;
	}

	public void set_refresh(int _refresh) {
		this._refresh = _refresh;
	}

}
