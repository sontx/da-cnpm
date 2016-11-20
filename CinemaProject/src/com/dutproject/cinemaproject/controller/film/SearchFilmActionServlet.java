package com.dutproject.cinemaproject.controller.film;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dutproject.cinemaproject.model.bean.Film;
import com.dutproject.cinemaproject.model.bo.schedule.FilmBO;

@WebServlet(name = "SearchFilmAction", urlPatterns = { "/film/SearchFilmAction" })
public class SearchFilmActionServlet extends FilmFilterServlet {
	private FilmBO filmBO = new FilmBO();

	@Override
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String keyword = request.getParameter("keyword");
		String sPageNumber = request.getParameter("page");
		int pageNumber = tryParseInt(sPageNumber, 1);
		List<Film> films = filmBO.searchFilm(keyword, pageNumber, 50);
		request.setAttribute("films", films);
		request.getRequestDispatcher("/jsp/film/FilmList.jsp").forward(request, response);
	}
}
