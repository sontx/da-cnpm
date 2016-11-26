package com.dutproject.cinemaproject.model.dao.reimplemented;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dutproject.cinemaproject.model.bean.Film;
import com.dutproject.cinemaproject.model.dao.service.FilmListener;

public class FilmJdbc extends JdbcService implements  FilmListener  {

	@Override
	public int getNumberOfFilms() {
		CallableStatement callable = null;
		int numberOfFilms = 0;
		try {
			callable = connection.prepareCall("{call film_getNumberOfFilms}");
			ResultSet resultSet = callable.executeQuery();
			if (resultSet.next())
				numberOfFilms = resultSet.getInt("numberOfFilms");
			resultSet.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (null != callable) {
				try {
					callable.close();
				} catch (SQLException e) {}
			}
		}
		return numberOfFilms;
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

	@Override
	public void addFilm(Film film) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Film getFilmByName(String name) {
		CallableStatement callable = null;
		Film film = new Film();
		try {
			callable = connection.prepareCall("{call film_getFilmByName(?)}");
			callable.setString(1, name);
			ResultSet resultSet = callable.executeQuery();
			if (resultSet.next()) {
				film.setFilmId(resultSet.getInt("filmId"));
				film.setFilmName(resultSet.getString("filmName"));
				film.setAgeLimithed(resultSet.getInt("ageLimited"));
				film.setDescription(resultSet.getString("description"));
				film.setLength(resultSet.getInt("length"));
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
		return film;
	}

	@Override
	public void deleteFilm(int id) {
		CallableStatement callable = null;
		try {
			callable = connection.prepareCall("{call film_deleteFilm(?)}");
			callable.setInt(1, id);
			callable.executeUpdate();
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
	}

	@Override
	public void updateFilm(Film film) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Film getFilmById(int id) {
		CallableStatement callable = null;
		Film film = new Film();
		try {
			callable = connection.prepareCall("{call film_getFilmById(?)}");
			callable.setInt(1, id);
			ResultSet resultSet = callable.executeQuery();
			if (resultSet.next()) {
				film.setFilmId(resultSet.getInt("filmId"));
				film.setFilmName(resultSet.getString("filmName"));
				film.setAgeLimithed(resultSet.getInt("ageLimited"));
				film.setDescription(resultSet.getString("description"));
				film.setLength(resultSet.getInt("length"));
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
		return film;
	}

	public int getNumberOfFilms(String keyword) {
		CallableStatement callable = null;
		int numberOfFilms = 0;
		try {
			callable = connection.prepareCall("{call film_searchFilmCount(?)}");
			callable.setString(1, keyword);
			ResultSet resultSet = callable.executeQuery();
			if (resultSet.next())
				numberOfFilms = resultSet.getInt(1);
			resultSet.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (null != callable) {
				try {
					callable.close();
				} catch (SQLException e) {}
			}
		}
		return numberOfFilms;
	}

	

}
