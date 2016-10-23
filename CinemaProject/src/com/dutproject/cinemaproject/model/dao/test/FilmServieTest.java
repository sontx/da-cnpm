package com.dutproject.cinemaproject.model.dao.test;

import java.util.ArrayList;
import java.util.List;

import com.dutproject.cinemaproject.model.bean.Film;
import com.dutproject.cinemaproject.model.dao.service.IShowFilmService;

public class FilmServieTest implements IShowFilmService {

	@Override
	public int getNumberOfFilms() {
		// TODO Auto-generated method stub
		return 3;
	}

	@Override
	public List<Film> getFilms(int offset, int count) {
		List<Film> films = new ArrayList<Film>();
		Film film = new Film();
		film.setFilmName("Diep Van 3");
		film.setFilmId(1);
		film.setAgeLimithed(16);
		film.setDescription("Phim hanh dong");
		film.setLength(360);
		films.add(film);
		return films;
	}

}
