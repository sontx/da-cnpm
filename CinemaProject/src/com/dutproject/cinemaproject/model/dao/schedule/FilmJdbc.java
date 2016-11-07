package com.dutproject.cinemaproject.model.dao.schedule;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dutproject.cinemaproject.model.bean.schedule.Film;
import com.dutproject.cinemaproject.model.dao.reimplemented.JdbcService;

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

}
