package com.dutproject.cinemaproject.model.bo;

import java.util.List;

import com.dutproject.cinemaproject.model.bean.Film;
import com.dutproject.cinemaproject.model.dao.FilmDao;
import com.dutproject.cinemaproject.model.dao.service.FilmListener;

public class FilmBo implements FilmListener {
	private static FilmBo sFilmBo = new FilmBo();
	private FilmDao mFilmDao;

	public static FilmBo getInstance() {
		return sFilmBo;
	}

	private FilmBo() {
		mFilmDao = new FilmDao();
	}

	@Override
	public int getNumberOfFilms() {
		// TODO Auto-generated method stub
		return mFilmDao.getNumberOfFilms();
	}

	@Override
	public List<Film> getFilms(int offset, int count) {
		// TODO Auto-generated method stub
		return mFilmDao.getFilms(offset, count);
	}

	@Override
	public void addFilm(Film film) {
		mFilmDao.addFilm(film);
	}

	@Override
	public Film getFilmByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteFilm(int id) {
		// TODO Auto-generated method stub

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

}
