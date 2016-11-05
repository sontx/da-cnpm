/**
 * 
 */
package com.dutproject.cinemaproject.controller.film;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dutproject.cinemaproject.controller.BaseServlet;
import com.dutproject.cinemaproject.model.bean.Film;
import com.dutproject.cinemaproject.model.bo.FilmBo;

/**
 * @author HoVanLy
 *
 *         Oct 30, 2016
 */
@WebServlet(name = "AddFilmAction", urlPatterns = { "/film/AddFilmForm" })
public class AddFilmServelet extends BaseServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private FilmBo mFilmBo = FilmBo.getInstance();

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.dutproject.cinemaproject.controller.BaseServlet#doWork(javax.servlet.
	 * http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doWork(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String duration = request.getParameter("duration");
		String description = request.getParameter("description");
		String oldLimited = request.getParameter("oldLimited");
		Film film = createFilm(name, duration, description, oldLimited);
		if (film != null) {
			boolean isAddResponse = mFilmBo.addFilm(film);
			if (isAddResponse) {

				request.setAttribute("message", "Added susscess!");
				request.getServletContext().getRequestDispatcher("/jsp/Success.jsp").forward(request, response);
			} else {
				request.setAttribute("message", "Error");
				request.getServletContext().getRequestDispatcher("/jsp/Error.jsp").forward(request, response);
			}

		} else {
			request.setAttribute("message", "Error");
			request.getServletContext().getRequestDispatcher("/jsp/Error.jsp").forward(request, response);
		}

	}

	private Film createFilm(String name, String duration, String description, String oldLimited) {
		Film film = new Film();
		if ("".equals(name) || "".equals(duration)) {
			return null;
		}
		film.setLength(Integer.parseInt(duration));
		film.setFilmName(name);
		film.setDescription(description);
		if (!"".equals("oldLimited")) {
			film.setAgeLimithed(Integer.parseInt(oldLimited));
		}
		return film;
	}

}
