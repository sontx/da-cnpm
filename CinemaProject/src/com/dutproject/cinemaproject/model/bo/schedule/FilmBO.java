package com.dutproject.cinemaproject.model.bo.schedule;

import java.sql.SQLException;
import java.util.List;

import com.dutproject.cinemaproject.model.bean.schedule.Film;
import com.dutproject.cinemaproject.model.dao.schedule.FilmDAO;

public class FilmBO {
	private FilmDAO filmDAO = new FilmDAO();

	public Film getFilmById(int filmId) {
		return filmDAO.getFilmById(filmId);
	}
	
	public List<Film> searchFilmByName(String keyword, int maxOfRecords) {
		return filmDAO.searchFilmByName(keyword, maxOfRecords);
	}

	public boolean checkExistFilmByFullName(String fullName) {
		return filmDAO.getFilmByName(fullName) != null;
	}

	public boolean addFilm(com.dutproject.cinemaproject.model.bean.Film film) {
		try {
			filmDAO.addFilm(film);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public boolean checkExistFilmById(int id) {
		return getFilmById(id) != null;
	}

	public boolean checkDuplicateFilmName(int id, String fullName) {
		com.dutproject.cinemaproject.model.bean.Film film = filmDAO.getFilmByName(fullName);
		return film != null && film.getFilmId() != id;
	}

	public boolean updateFilm(com.dutproject.cinemaproject.model.bean.Film film) {
		try {
			filmDAO.updateFilm(film);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public com.dutproject.cinemaproject.model.bean.Film getFilm(int filmId) {
		try {
			return filmDAO.getFilm(filmId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
