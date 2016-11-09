package com.dutproject.cinemaproject.controller.ticket;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dutproject.cinemaproject.model.bean.Movie;
import com.dutproject.cinemaproject.model.bo.TicketBO;

/**
 * Servlet implementation class MovieListServlet
 */
@WebServlet("/MovieListServlet")
public class MovieListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static int MAX_SCHEDULE_PER_PAGE = 2;
	private TicketBO ticketBO = new TicketBO();

	private int tryParseInt(String str, int defaultValue) {
		try {
			return Integer.parseInt(str);
		} catch (Exception e) {
			return defaultValue;
		}
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MovieListServlet() {

	}

	private int getPageNumber(HttpServletRequest request) {
		String str_pageNumber = request.getParameter("pageNumber");
		int pageNumber;
		try {
			pageNumber = Integer.parseInt(str_pageNumber);
		} catch (Exception e) {
			pageNumber = 1;
		}

		if (pageNumber <= 0) {
			pageNumber = 1;
		}

		int maxPageNumber = getMaxPageNumber();
		if (pageNumber > maxPageNumber) {
			pageNumber = maxPageNumber;
		}

		return pageNumber;
	}

	private int getMaxPageNumber() {
		int numOfSchedules = ticketBO.getNumberOfMovies();
		return numOfSchedules / MAX_SCHEDULE_PER_PAGE + 1;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int pageNumber = getPageNumber(request);
		int maxPageNumber = getMaxPageNumber();
		List<Movie> movies = ticketBO.getMovies(pageNumber, MAX_SCHEDULE_PER_PAGE);
		request.setAttribute("pageNumber", pageNumber);
		request.setAttribute("maxPageNumber", maxPageNumber);
		request.setAttribute("movies", movies);
		request.getRequestDispatcher("/jsp/Ticket/ScheduleList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
