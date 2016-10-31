package com.dutproject.cinemaproject.model.bo.schedule;

import com.dutproject.cinemaproject.model.bean.schedule.Film;
import com.dutproject.cinemaproject.model.dao.schedule.FilmDAO;

public class FilmBO {
	private FilmDAO filmDAO = new FilmDAO();

	public Film getFilmById(int filmId) {
		return filmDAO.getFilmById(filmId);
	}
}
