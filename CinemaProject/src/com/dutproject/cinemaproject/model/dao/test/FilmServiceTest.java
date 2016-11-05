package com.dutproject.cinemaproject.model.dao.test;

import java.util.ArrayList;
import java.util.List;

import com.dutproject.cinemaproject.model.bean.Film;
import com.dutproject.cinemaproject.model.dao.service.ManagementFilmListener;

public class FilmServiceTest implements ManagementFilmListener {

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
		
		Film film1 = new Film();
		film1.setFilmName("Tam Cam");
		film1.setFilmId(2);
		film1.setAgeLimithed(18);
		film1.setDescription("Co tich");
		film1.setLength(180);
		
		films.add(film1);
		films.add(film);
		return films;
	}

	/* (non-Javadoc)
	 * @see com.dutproject.cinemaproject.model.dao.service.ManagementFilmListener#addFilm(com.dutproject.cinemaproject.model.bean.Film)
	 */
	@Override
	public boolean addFilm(Film film) {
		// TODO Auto-generated method stub
		return true;
	}

}
