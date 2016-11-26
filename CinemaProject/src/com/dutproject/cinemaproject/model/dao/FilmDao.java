package com.dutproject.cinemaproject.model.dao;

import java.util.List;

import com.dutproject.cinemaproject.model.bean.Film;
import com.dutproject.cinemaproject.model.dao.reimplemented.FilmJdbc;
import com.dutproject.cinemaproject.model.dao.service.FilmListener;

public class FilmDao implements FilmListener {
	// replace FilmJdbc here;
	private FilmJdbc mFilmJdbc = new FilmJdbc();
	
	@Override
	public int getNumberOfFilms() {
		// TODO Auto-generated method stub
		return mFilmJdbc.getNumberOfFilms();
	}

	@Override
	public List<Film> getFilms(int offset, int count) {
		// TODO Auto-generated method stub
		return mFilmJdbc.getFilms(offset, count);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.dutproject.cinemaproject.model.dao.service.ManagementFilmListener#
	 * addFilm(com.dutproject.cinemaproject.model.bean.Film)
	 */
	@Override
	public void addFilm(Film film) {
		// TODO Auto-generated method stub

	}

	@Override
	public Film getFilmByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateFilm(Film film) {
		// TODO Auto-generated method stub

	}

	@Override
	public Film getFilmById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteFilm(int id) {
		// TODO Auto-generated method stub

	}

	public int getNumberOfFilms(String keyword) {
		return mFilmJdbc.getNumberOfFilms(keyword);
	}

}
