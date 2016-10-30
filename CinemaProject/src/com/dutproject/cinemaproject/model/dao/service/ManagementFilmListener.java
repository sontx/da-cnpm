package com.dutproject.cinemaproject.model.dao.service;

import java.util.List;

import com.dutproject.cinemaproject.model.bean.Film;

public interface ManagementFilmListener {
	int getNumberOfFilms();
	List<Film> getFilms(int offset, int count);
	boolean addFilm(Film film);
}
