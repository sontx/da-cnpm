package com.dutproject.cinemaproject.model.dao.reimplemented;

import java.util.List;

import com.dutproject.cinemaproject.model.bean.Film;
import com.dutproject.cinemaproject.model.dao.service.IShowFilmService;

public class FilmJdbc extends JdbcService implements  IShowFilmService  {

	@Override
	public int getNumberOfFilms() {
		
		return 0;
	}

	@Override
	public List<Film> getFilms(int offset, int count) {
		// TODO Auto-generated method stub
		return null;
	}

}
