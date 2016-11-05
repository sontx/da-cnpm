package com.dutproject.cinemaproject.model.dao.reimplemented;

import java.util.List;

import com.dutproject.cinemaproject.model.bean.Film;
import com.dutproject.cinemaproject.model.dao.service.ManagementFilmListener;

public class FilmJdbc extends JdbcService implements  ManagementFilmListener  {

	@Override
	public int getNumberOfFilms() {
		
		return 0;
	}

	@Override
	public List<Film> getFilms(int offset, int count) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.dutproject.cinemaproject.model.dao.service.ManagementFilmListener#addFilm(com.dutproject.cinemaproject.model.bean.Film)
	 */
	@Override
	public boolean addFilm(Film film) {
		// TODO Auto-generated method stub
		return false;
	}

}
