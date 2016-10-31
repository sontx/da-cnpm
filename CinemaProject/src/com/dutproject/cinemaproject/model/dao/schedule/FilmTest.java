package com.dutproject.cinemaproject.model.dao.schedule;

import java.util.ArrayList;
import java.util.List;

import com.dutproject.cinemaproject.model.bean.schedule.Film;

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

}
