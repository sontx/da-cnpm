package com.dutproject.cinemaproject.model.bo;

import java.util.List;

import com.dutproject.cinemaproject.model.bean.Film;
import com.dutproject.cinemaproject.model.dao.FilmDao;

public class FilmBo {
	private static FilmBo mFilmBo = new FilmBo();
	private FilmDao filmDao;
	public static FilmBo getInstance(){
		return mFilmBo;
	}
	private FilmBo(){
		filmDao = new FilmDao();
	}
	
	public int getNumberOfFilms() {
		// TODO Auto-generated method stub
		return filmDao.getNumberOfFilms();
	}

	public List<Film> getFilms(int offset, int count) {
		// TODO Auto-generated method stub
		return filmDao.getFilms(1, 100);
	}

}
