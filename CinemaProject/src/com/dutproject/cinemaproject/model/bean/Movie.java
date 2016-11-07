package com.dutproject.cinemaproject.model.bean;

public class Movie {
	private int id;
	private String nameOfMovie;
	private String schedule;

	public Movie(int id, String nameOfMovie, String schedule) {
		super();
		this.id = id;
		this.nameOfMovie = nameOfMovie;
		this.schedule = schedule;
	}

	public Movie() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNameOfMovie() {
		return nameOfMovie;
	}

	public void setNameOfMovie(String nameOfMovie) {
		this.nameOfMovie = nameOfMovie;
	}

	public String getSchedule() {
		return schedule;
	}

	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}

}
