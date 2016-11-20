package com.dutproject.cinemaproject.controller.film;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dutproject.cinemaproject.controller.BaseServlet;

@WebServlet(name = "UpdateFilmForm", urlPatterns = { "/film/UpdateFilmForm" })
public class UpdateFilmFormServlet extends FilmFilterServlet {

	@Override
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/jsp/film/UpdateFilmForm.jsp").forward(request, response);
	}

}
