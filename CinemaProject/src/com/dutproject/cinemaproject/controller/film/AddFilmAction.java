package com.dutproject.cinemaproject.controller.film;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dutproject.cinemaproject.controller.BaseServlet;
import com.dutproject.cinemaproject.model.bean.Film;
import com.dutproject.cinemaproject.model.bo.schedule.FilmBO;

@WebServlet(name = "AddFilmAction", urlPatterns = { "/film/AddFilmAction" })
public class AddFilmAction extends FilmFilterServlet {
	private FilmBO filmBO = new FilmBO();

	@Override
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String fullName = request.getParameter("fullName");
		String sDuration = request.getParameter("duration");
		String description = request.getParameter("description");
		String sAgeLimited = request.getParameter("ageLimited");

		if (!filmBO.checkExistFilmByFullName(fullName)) {
			int duration = tryParseInt(sDuration, -1);
			if (duration > 0) {
				int ageLimited = tryParseInt(sAgeLimited, 0);
				Film film = new Film();
				film.setFilmName(fullName);
				film.setLength(duration);
				film.setDescription(description);
				film.setAgeLimithed(ageLimited);
				if (filmBO.addFilm(film))
					showSuccessMessage("Added film " + fullName, "FilmList", request, response);
				else
					showErrorMessage("Something wrong when add new film.", "AddFilmForm", request, response);
			} else {
				showErrorMessage("Duration must greater than 0.", "AddFilmForm", request, response);
			}
		} else {
			showErrorMessage("Film alreay exists.", "AddFilmForm", request, response);
		}
	}

}
