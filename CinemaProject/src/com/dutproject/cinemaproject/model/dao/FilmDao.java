package com.dutproject.cinemaproject.model.dao;

import java.util.List;

import com.dutproject.cinemaproject.model.bean.Film;
import com.dutproject.cinemaproject.model.dao.service.IShowFilmService;
import com.dutproject.cinemaproject.model.dao.test.FilmServiceTest;

public class FilmDao implements IShowFilmService{
	// replace FilmJdbc here;
    FilmServiceTest fimlServiceTest = new FilmServiceTest();
	@Override
	public int getNumberOfFilms() {
		// TODO Auto-generated method stub
		return fimlServiceTest.getNumberOfFilms();
	}

	@Override
	public List<Film> getFilms(int offset, int count) {
		// TODO Auto-generated method stub
		return fimlServiceTest.getFilms(1, 100);
	}

}
