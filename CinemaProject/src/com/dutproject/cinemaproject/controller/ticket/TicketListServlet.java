package com.dutproject.cinemaproject.controller.ticket;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dutproject.cinemaproject.model.bean.Ticket;
import com.dutproject.cinemaproject.model.bo.TicketBO;

/**
 * Servlet implementation class TicketListServlet
 */
@WebServlet("/TicketListServlet")
public class TicketListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final int MAX_TICKET_PER_PAGE = 2;
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
	public TicketListServlet() {
	}

	private int getPageNumber(HttpServletRequest request, int id) {
		String str_pageNumber = request.getParameter("pageNumber");
		int pageNumber;
		try {
			pageNumber = tryParseInt(str_pageNumber, 0);
		} catch (Exception e) {
			pageNumber = 1;
		}

		if (pageNumber <= 0) {
			pageNumber = 1;
		}

		int maxPageNumber = getMaxPageNumber(id);
		if (pageNumber > maxPageNumber) {
			pageNumber = maxPageNumber;
		}

		return pageNumber;
	}

	private int getMaxPageNumber(int id) {
		int numOfTickets = ticketBO.getNumberOfTickets(id);
		return numOfTickets / MAX_TICKET_PER_PAGE + 1;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idMovie = request.getParameter("scheduleId");
		int id = tryParseInt(idMovie, 0);
		int pageNumber = getPageNumber(request, id);
		int maxPageNumber = getMaxPageNumber(id);
		
		//System.out.println(ticketBO.getNumberOfTickets(id));

		List<Ticket> tickets = ticketBO.getTickets(pageNumber, MAX_TICKET_PER_PAGE, id);
		request.setAttribute("pageNumber", pageNumber);
		request.setAttribute("maxPageNumber", maxPageNumber);
		request.setAttribute("scheduleId", id);
		request.setAttribute("tickets", tickets);
		request.getRequestDispatcher("/jsp/Ticket/TicketsList.jsp").forward(request, response);

	}

}
