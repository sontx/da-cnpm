package com.dutproject.cinemaproject.model.bean;
/**
 * 
 * @author HoVanLy
 *
 */
public class Film {
	private int filmId;
	private int length;
	private String filmName;
	private String description;
	private int ageLimithed;

	public int getFilmId() {
		return filmId;
	}

	public void setFilmId(int filmId) {
		this.filmId = filmId;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public String getFilmName() {
		return filmName;
	}

	public void setFilmName(String filmName) {
		this.filmName = filmName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getAgeLimithed() {
		return ageLimithed;
	}

	public void setAgeLimithed(int ageLimithed) {
		this.ageLimithed = ageLimithed;
	}

}
