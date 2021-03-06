package com.dutproject.cinemaproject.model.dao.schedule.service;

import java.sql.SQLException;
import java.util.List;

import com.dutproject.cinemaproject.model.bean.schedule.Film;

public interface IFilmService {
	
	public Film getFilmById(int filmId);
	public List<Film> searchFilmByName(String keyword, int maxOfRecords);
	public com.dutproject.cinemaproject.model.bean.Film getFilmByName(String fullName) throws SQLException;
	public void addFilm(com.dutproject.cinemaproject.model.bean.Film film) throws SQLException;
	public void updateFilm(com.dutproject.cinemaproject.model.bean.Film film) throws SQLException;
	public com.dutproject.cinemaproject.model.bean.Film getFilm(int filmId) throws SQLException;
	public void deleteFilm(int id) throws SQLException;
	public List<com.dutproject.cinemaproject.model.bean.Film> searchFilm(String keyword, int pageNumber, int maxOfRecords) throws SQLException;
	
}
