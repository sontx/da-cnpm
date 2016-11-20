package com.dutproject.cinemaproject.model.dao.schedule;

import java.sql.SQLException;
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

	public com.dutproject.cinemaproject.model.bean.Film getFilmByName(String fullName) {
		try {
			return filmService.getFilmByName(fullName);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public void addFilm(com.dutproject.cinemaproject.model.bean.Film film) throws SQLException {
		filmService.addFilm(film);
	}

	public void updateFilm(com.dutproject.cinemaproject.model.bean.Film film) throws SQLException {
		filmService.updateFilm(film);
	}

}
