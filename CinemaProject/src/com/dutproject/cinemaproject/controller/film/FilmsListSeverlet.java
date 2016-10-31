/**
 * 
 */
package com.dutproject.cinemaproject.controller.film;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import com.dutproject.cinemaproject.controller.BaseServlet;
import com.dutproject.cinemaproject.model.bean.Film;
import com.dutproject.cinemaproject.model.bo.FilmBo;

/**
 * @author HoVanLy
 *
 * Oct 23, 2016
 */
@WebServlet(name = "FilmsList", urlPatterns = { "/film/FilmList" })
public class FilmsListSeverlet extends BaseServlet {
	private FilmBo mFilmBo = FilmBo.getInstance();
	private static final long serialVersionUID = 1L;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.dutproject.cinemaproject.controller.BaseServlet#doWork()
	 */
	@Override
	protected void doWork() throws IOException, ServletException {
		String sPageNumber = request.getParameter("page");
		int pageNumber = tryParseInt(sPageNumber, 1) - 1;
		List<Film> films = mFilmBo.getFilms(pageNumber * 50, 50);
		setAttribute("films", films);
		request.getRequestDispatcher("/jsp/film/FilmList.jsp").forward(request, response);
	}

	private int tryParseInt(String st, int defaultValue) {
		try {
			return Integer.parseInt(st);
		} catch (NumberFormatException ignored) {
			return defaultValue;
		}
	}
}
