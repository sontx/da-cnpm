package com.dutproject.cinemaproject.model.dao.schedule.service;

import java.util.List;

import com.dutproject.cinemaproject.model.bean.schedule.Film;

public interface IFilmService {
	
	public Film getFilmById(int filmId);
	public List<Film> searchFilmByName(String keyword, int maxOfRecords);
	
}
