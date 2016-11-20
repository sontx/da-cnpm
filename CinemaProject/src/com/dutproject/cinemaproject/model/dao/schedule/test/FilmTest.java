package com.dutproject.cinemaproject.model.dao.schedule.test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dutproject.cinemaproject.model.bean.schedule.Film;
import com.dutproject.cinemaproject.model.dao.schedule.service.IFilmService;

public class FilmTest implements IFilmService {

	@Override
	public Film getFilmById(int filmId) {
		switch (filmId) {
		case 1: return new Film(1, "Phim ABC");
		case 2: return new Film(2, "Phim XYZ");
		case 3: return new Film(3, "Phim XXX");
		default:
			break;
		}
		return null;
	}

	@Override
	public List<Film> searchFilmByName(String keyword, int maxOfRecords) {
		List<Film> listFilms = new ArrayList<Film>();
		listFilms.add(new Film(1, "Phim ABC"));
		listFilms.add(new Film(2, "Phim XYZ"));
		listFilms.add(new Film(3, "Phim XXX"));
		return listFilms;
	}

	@Override
	public com.dutproject.cinemaproject.model.bean.Film getFilmByName(String fullName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addFilm(com.dutproject.cinemaproject.model.bean.Film film) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateFilm(com.dutproject.cinemaproject.model.bean.Film film) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public com.dutproject.cinemaproject.model.bean.Film getFilm(int filmId) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteFilm(int id) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<com.dutproject.cinemaproject.model.bean.Film> searchFilm(String keyword, int pageNumber,
			int maxOfRecords) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
