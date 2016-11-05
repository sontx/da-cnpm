package com.dutproject.cinemaproject.model.bo.schedule;

import java.util.List;

import com.dutproject.cinemaproject.model.bean.schedule.Film;
import com.dutproject.cinemaproject.model.dao.schedule.FilmDAO;

public class FilmBO {
	private FilmDAO filmDAO = new FilmDAO();

	public Film getFilmById(int filmId) {
		return filmDAO.getFilmById(filmId);
	}
	
	public List<Film> searchFilmByName(String keyword, int maxOfRecords) {
		return filmDAO.searchFilmByName(keyword, maxOfRecords);
	}
}
