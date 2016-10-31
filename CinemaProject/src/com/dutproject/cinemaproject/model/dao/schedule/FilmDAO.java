package com.dutproject.cinemaproject.model.dao.schedule;

import com.dutproject.cinemaproject.model.bean.schedule.Film;

public class FilmDAO implements IFilmService {
	IFilmService filmService = new FilmTest();

	@Override
	public Film getFilmById(int filmId) {
		return filmService.getFilmById(filmId);
	}

}
