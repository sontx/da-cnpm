package com.dutproject.cinemaproject.controller.film;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dutproject.cinemaproject.model.bo.schedule.FilmBO;

@WebServlet(name = "DeleteFilmAction", urlPatterns = { "/film/DeleteFilmAction" })
public class DeleteFilmActionServlet extends FilmFilterServlet {
	private static final long serialVersionUID = 1L;
	private FilmBO filmBO = new FilmBO();
	
	@Override
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sId = request.getParameter("id");
		int id = tryParseInt(sId, -1);
		if (filmBO.checkExistFilmById(id)) {
			filmBO.deleteFilm(id);
			showSuccessMessage("Removed successful", "FilmList", request, response);
		} else {
			showErrorMessage("Film do not exist", "FilmList", request, response);
		}
	}

}
