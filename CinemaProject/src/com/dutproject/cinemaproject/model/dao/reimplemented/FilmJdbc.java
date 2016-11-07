package com.dutproject.cinemaproject.model.dao.reimplemented;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
		CallableStatement callable = null;
		List<Film> films = new ArrayList<>();
		try {
			callable = connection.prepareCall("{call film_getFilms(?,?)}");
			callable.setInt(1, offset);
			callable.setInt(2, count);
			ResultSet resultSet = callable.executeQuery();
			while (resultSet.next()) {
				Film film = new Film();
				film.setFilmId(resultSet.getInt("filmId"));
				film.setFilmName(resultSet.getString("filmName"));
				film.setAgeLimithed(resultSet.getInt("ageLimited"));
				film.setDescription(resultSet.getString("description"));
				film.setLength(resultSet.getInt("length"));
				films.add(film);
			}
			resultSet.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (callable != null) {
				try {
					callable.close();
				} catch (SQLException e) {
				}
			}
		}
		return films;
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
