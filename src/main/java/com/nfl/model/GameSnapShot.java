package com.nfl.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

public class GameSnapShot {
	private int gameId;
	private int gameKey;

	private String sourceDate;
	private String homeTeamClubCode;
	private String homeTeamNFLTriCode;
	private int homeTeamScore;

	private int awayTeamScore;
	private String awayTeamClubCode;
	private String awayTeamNFLTriCode;

	private String clock;
	private String phase;
	private String possession;

	private String territory;

	private KickoffDate kickoffDate;
	private int down;
	private int yardLine;
	private int yardsToGo;
	private int _chipOrder;

	public GameSnapShot() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GameSnapShot(int gameId, int gameKey, String sourceDate, String homeTeamClubCode, String homeTeamNFLTriCode,
			int homeTeamScore, int awayTeamScore, String awayTeamClubCode, String awayTeamNFLTriCode, String clock,
			String phase, String possession, String territory, KickoffDate kickoffDate, int down, int yardLine,
			int yardsToGo, int _chipOrder) {
		super();
		this.gameId = gameId;
		this.gameKey = gameKey;
		this.sourceDate = sourceDate;
		this.homeTeamClubCode = homeTeamClubCode;
		this.homeTeamNFLTriCode = homeTeamNFLTriCode;
		this.homeTeamScore = homeTeamScore;
		this.awayTeamScore = awayTeamScore;
		this.awayTeamClubCode = awayTeamClubCode;
		this.awayTeamNFLTriCode = awayTeamNFLTriCode;
		this.clock = clock;
		this.phase = phase;
		this.possession = possession;
		this.territory = territory;
		this.kickoffDate = kickoffDate;
		this.down = down;
		this.yardLine = yardLine;
		this.yardsToGo = yardsToGo;
		this._chipOrder = _chipOrder;
	}

	public int getGameId() {
		return gameId;
	}

	public void setGameId(int gameId) {
		this.gameId = gameId;
	}

	public int getGameKey() {
		return gameKey;
	}

	public void setGameKey(int gameKey) {
		this.gameKey = gameKey;
	}

	public String getSourceDate() {
		return sourceDate;
	}

	public void setSourceDate(String sourceDate) {
		this.sourceDate = sourceDate;
	}

	public String getHomeTeamClubCode() {
		return homeTeamClubCode;
	}

	public void setHomeTeamClubCode(String homeTeamClubCode) {
		this.homeTeamClubCode = homeTeamClubCode;
	}

	public String getHomeTeamNFLTriCode() {
		return homeTeamNFLTriCode;
	}

	public void setHomeTeamNFLTriCode(String homeTeamNFLTriCode) {
		this.homeTeamNFLTriCode = homeTeamNFLTriCode;
	}

	public int getHomeTeamScore() {
		return homeTeamScore;
	}

	public void setHomeTeamScore(int homeTeamScore) {
		this.homeTeamScore = homeTeamScore;
	}

	public int getAwayTeamScore() {
		return awayTeamScore;
	}

	public void setAwayTeamScore(int awayTeamScore) {
		this.awayTeamScore = awayTeamScore;
	}

	public String getAwayTeamClubCode() {
		return awayTeamClubCode;
	}

	public void setAwayTeamClubCode(String awayTeamClubCode) {
		this.awayTeamClubCode = awayTeamClubCode;
	}

	public String getAwayTeamNFLTriCode() {
		return awayTeamNFLTriCode;
	}

	public void setAwayTeamNFLTriCode(String awayTeamNFLTriCode) {
		this.awayTeamNFLTriCode = awayTeamNFLTriCode;
	}

	public String getClock() {
		return clock;
	}

	public void setClock(String clock) {
		this.clock = clock;
	}

	public String getPhase() {
		return phase;
	}

	public void setPhase(String phase) {
		this.phase = phase;
	}

	public String getPossession() {
		return possession;
	}

	public void setPossession(String possession) {
		this.possession = possession;
	}

	public String getTerritory() {
		return territory;
	}

	public void setTerritory(String territory) {
		this.territory = territory;
	}

	public KickoffDate getKickoffDate() {
		return kickoffDate;
	}

	public void setKickoffDate(KickoffDate kickoffDate) {
		this.kickoffDate = kickoffDate;
	}

	public int getDown() {
		return down;
	}

	public void setDown(int down) {
		this.down = down;
	}

	public int getYardLine() {
		return yardLine;
	}

	public void setYardLine(int yardLine) {
		this.yardLine = yardLine;
	}

	public int getYardsToGo() {
		return yardsToGo;
	}

	public void setYardsToGo(int yardsToGo) {
		this.yardsToGo = yardsToGo;
	}

	public int get_chipOrder() {
		return _chipOrder;
	}

	public void set_chipOrder(int _chipOrder) {
		this._chipOrder = _chipOrder;
	}

}
