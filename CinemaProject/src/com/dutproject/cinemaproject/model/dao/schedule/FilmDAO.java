package com.dutproject.cinemaproject.model.dao.schedule;

import java.util.List;

import com.dutproject.cinemaproject.model.bean.schedule.Film;
import com.dutproject.cinemaproject.model.dao.schedule.reimplemented.FilmJdbc;
import com.dutproject.cinemaproject.model.dao.schedule.service.IFilmService;

public class FilmDAO implements IFilmService {
//	IFilmService filmService = new FilmTest();
	private IFilmService filmService = new FilmJdbc();

	@Override
	public Film getFilmById(int filmId) {
		return filmService.getFilmById(filmId);
	}

	@Override
	public List<Film> searchFilmByName(String keyword, int maxOfRecords) {
		return filmService.searchFilmByName(keyword, maxOfRecords);
	}

}
