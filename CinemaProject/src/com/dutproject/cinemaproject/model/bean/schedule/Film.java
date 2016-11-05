package com.dutproject.cinemaproject.model.bean.schedule;

public class Film {
	private int filmId;
	private String filmName;
	
	public Film() {
	}

	public Film(int filmId, String filmName) {
		setFilmId(filmId);
		setFilmName(filmName);
	}

	public int getFilmId() {
		return filmId;
	}

	public void setFilmId(int filmId) {
		this.filmId = filmId;
	}

	public String getFilmName() {
		return filmName;
	}

	public void setFilmName(String filmName) {
		this.filmName = filmName;
	}
	
}
