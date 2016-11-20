package com.dutproject.cinemaproject.model.dao.schedule.reimplemented;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dutproject.cinemaproject.model.bean.schedule.Film;
import com.dutproject.cinemaproject.model.dao.reimplemented.JdbcService;
import com.dutproject.cinemaproject.model.dao.schedule.service.IFilmService;

public class FilmJdbc extends JdbcService implements IFilmService {

	@Override
	public Film getFilmById(int filmId) {
		CallableStatement callable = null;
		try {
			callable = connection.prepareCall("{call schedule_getFilmById(?)}");
			callable.setInt(1, filmId);
			ResultSet rs = callable.executeQuery();
			Film film = null;
			if (rs.next()) {
				film = parseResultSetToFilm(rs);
			}
			rs.close();
			return film;
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
		return null;
	}

	private Film parseResultSetToFilm(ResultSet rs) throws SQLException {
		int filmId = rs.getInt("filmId");
		String filmName = rs.getString("filmName");
		return new Film(filmId, filmName);
	}

	@Override
	public List<Film> searchFilmByName(String keyword, int maxOfRecords) {
		CallableStatement callable = null;
		try {
			callable = connection.prepareCall("{call schedule_getFilmWithName(?)}");
			callable.setString(1, keyword);
			ResultSet rs = callable.executeQuery();
			List<Film> listFilms = parseResultSetToListFilms(rs);
			rs.close();
			return listFilms;
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
		return null;
	}

	private List<Film> parseResultSetToListFilms(ResultSet rs) throws SQLException {
		List<Film> listFilm = new ArrayList<Film>();
		while (rs.next()) {
			listFilm.add(parseResultSetToFilm(rs));
		}
		return listFilm;
	}

	@Override
	public com.dutproject.cinemaproject.model.bean.Film getFilmByName(String fullName) throws SQLException {
		CallableStatement callable = null;
		try {
			callable = connection.prepareCall("{call [film_getFilmByName](?)}");
			callable.setString(1, fullName);
			ResultSet rs = callable.executeQuery();
			com.dutproject.cinemaproject.model.bean.Film film = null;
			if (rs.next()) {
				film = new com.dutproject.cinemaproject.model.bean.Film();
				int filmId = rs.getInt("filmId");
				String filmName = rs.getString("filmName");
				String description = rs.getString("description");
				int length = rs.getInt("length");
				int ageLimited = rs.getInt("ageLimited");
				film.setFilmId(filmId);
				film.setFilmName(filmName);
				film.setDescription(description);
				film.setLength(length);
				film.setAgeLimithed(ageLimited);
			}
			rs.close();
			return film;
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
	public void addFilm(com.dutproject.cinemaproject.model.bean.Film film) throws SQLException {
		CallableStatement callable = null;
		try {
			callable = connection.prepareCall("{call [film_addFilm](?,?,?,?)}");
			callable.setInt(1, film.getLength());
			callable.setString(2, film.getFilmName());
			callable.setString(3, film.getDescription());
			callable.setInt(4, film.getAgeLimithed());
			callable.executeUpdate();
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
	public void updateFilm(com.dutproject.cinemaproject.model.bean.Film film) throws SQLException {
		CallableStatement callable = null;
		try {
			callable = connection.prepareCall("{call [film_updateFilm](?,?,?,?,?)}");
			callable.setInt(1, film.getFilmId());
			callable.setInt(2, film.getLength());
			callable.setString(3, film.getFilmName());
			callable.setString(4, film.getDescription());
			callable.setInt(5, film.getAgeLimithed());
			callable.executeUpdate();
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
	public com.dutproject.cinemaproject.model.bean.Film getFilm(int filmId) throws SQLException {
		CallableStatement callable = null;
		try {
			callable = connection.prepareCall("{call [film_getFilmById](?)}");
			callable.setInt(1, filmId);
			ResultSet rs = callable.executeQuery();
			com.dutproject.cinemaproject.model.bean.Film film = null;
			if (rs.next()) {
				film = new com.dutproject.cinemaproject.model.bean.Film();
				String filmName = rs.getString("filmName");
				String description = rs.getString("description");
				int length = rs.getInt("length");
				int ageLimited = rs.getInt("ageLimited");
				film.setFilmId(filmId);
				film.setFilmName(filmName);
				film.setDescription(description);
				film.setLength(length);
				film.setAgeLimithed(ageLimited);
			}
			rs.close();
			return film;
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
	public void deleteFilm(int id) throws SQLException {
		CallableStatement callable = null;
		try {
			callable = connection.prepareCall("{call [film_deleteFilm](?)}");
			callable.setInt(1, id);
			callable.executeUpdate();
		} finally {
			if (callable != null) {
				try {
					callable.close();
				} catch (SQLException e) {
				}
			}
		}
	}

}
