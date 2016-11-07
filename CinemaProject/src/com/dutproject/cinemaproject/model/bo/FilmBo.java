package com.dutproject.cinemaproject.model.bo;

import java.util.List;

import com.dutproject.cinemaproject.model.bean.Film;
import com.dutproject.cinemaproject.model.dao.FilmDao;

public class FilmBo {
	private static FilmBo sFilmBo = new FilmBo();
	private FilmDao mFilmDao;
	public static FilmBo getInstance(){
		return sFilmBo;
	}
	private FilmBo(){
		mFilmDao = new FilmDao();
	}
	
	public int getNumberOfFilms() {
		// TODO Auto-generated method stub
		return mFilmDao.getNumberOfFilms();
	}

	public List<Film> getFilms(int offset, int count) {
		// TODO Auto-generated method stub
		return mFilmDao.getFilms(offset, count);
	}
	
	public boolean addFilm(Film film){
		return mFilmDao.addFilm(film);
	}

}
