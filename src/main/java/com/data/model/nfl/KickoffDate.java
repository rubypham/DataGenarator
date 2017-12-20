package com.data.model.nfl;

public class KickoffDate {
	private String _GMT;
	private String __text;

	public KickoffDate() {
		super();
	}

	public KickoffDate(String _GMT, String __text) {
		super();
		this._GMT = _GMT;
		this.__text = __text;
	}

	public String get_GMT() {
		return _GMT;
	}

	public void set_GMT(String _GMT) {
		this._GMT = _GMT;
	}

	public String get__text() {
		return __text;
	}

	public void set__text(String __text) {
		this.__text = __text;
	}

}
