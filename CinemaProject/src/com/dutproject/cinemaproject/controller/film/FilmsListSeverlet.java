/**
 * 
 */
package com.dutproject.cinemaproject.controller.film;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dutproject.cinemaproject.controller.BaseServlet;
import com.dutproject.cinemaproject.model.bean.Film;
import com.dutproject.cinemaproject.model.bo.FilmBo;
import com.dutproject.cinemaproject.model.bo.schedule.FilmBO;

/**
 * @author HoVanLy
 *
 *         Oct 23, 2016
 */
@WebServlet(name = "FilmsList", urlPatterns = { "/film/FilmList" })
public class FilmsListSeverlet extends FilmFilterServlet {
	private FilmBo mFilmBo = FilmBo.getInstance();
	private FilmBO filmBO = new FilmBO();
	private static final long serialVersionUID = 1L;
	private static final int MAX_ENTRIES = 5;

	@Override
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String keyword = request.getParameter("keyword");
		int maxPageNumber = getMaxPageNumber(keyword);
		int pageNumber = getPageNumber(request, maxPageNumber);
		List<Film> films;
		
		if (keyword == null) {
			keyword = "";
			films = mFilmBo.getFilms(pageNumber, MAX_ENTRIES);
		} else {
			films = filmBO.searchFilm(keyword, pageNumber, MAX_ENTRIES);
		}
		request.setAttribute("keyword", keyword);
		request.setAttribute("films", films);
		request.setAttribute("pageNumber", pageNumber);
		request.setAttribute("maxPageNumber", maxPageNumber);
		request.getRequestDispatcher("/jsp/film/FilmList.jsp").forward(request, response);
	}

	private int getMaxPageNumber(String keyword) {
		int numOfFilms = keyword == null || "".equals(keyword) ? mFilmBo.getNumberOfFilms() : mFilmBo.getNumberOfFilms(keyword);
		int maxPageNumber = (numOfFilms + MAX_ENTRIES - 1) / MAX_ENTRIES;
		return maxPageNumber;
	}

	private int getPageNumber(HttpServletRequest request, int maxPageNumber) {
		String sPageNumber = request.getParameter("page");
		int pageNumber = tryParseInt(sPageNumber, 1);
		if (0 >= pageNumber)
			pageNumber = 1;
		if (maxPageNumber < pageNumber)
			pageNumber = maxPageNumber;
		return pageNumber;
	}
}
