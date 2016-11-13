package com.dutproject.cinemaproject.model.dao.service;

import java.util.List;

import com.dutproject.cinemaproject.model.bean.Film;

public interface FilmListener {
	int getNumberOfFilms();
	List<Film> getFilms(int offset, int count);
	void addFilm(Film film);
	Film getFilmByName(String name);
	void deleteFilm(int id);
	void updateFilm(Film film);
	Film getFilmById(int id);
}
