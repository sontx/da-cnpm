package com.dutproject.cinemaproject.controller.film;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dutproject.cinemaproject.controller.BaseServlet;
import com.dutproject.cinemaproject.model.bean.AccountProfile;
import com.dutproject.cinemaproject.model.bean.Film;
import com.dutproject.cinemaproject.model.bo.schedule.FilmBO;

@WebServlet(name = "UpdateFilmForm", urlPatterns = { "/film/UpdateFilmForm" })
public class UpdateFilmFormServlet extends FilmFilterServlet {
	private FilmBO filmBO = new FilmBO();

	@Override
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sid = request.getParameter("id");
		int filmId = tryParseInt(sid, -1);
		Film film = filmBO.getFilm(filmId);
		if (film != null) {
			request.setAttribute("film", film);
			request.getRequestDispatcher("/jsp/film/UpdateFilmForm.jsp").forward(request, response);
		} else {

		}
	}

}
