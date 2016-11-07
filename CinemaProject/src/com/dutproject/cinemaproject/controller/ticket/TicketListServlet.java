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
		String sPageNumber = request.getParameter("page");
		int pageNumber = tryParseInt(sPageNumber, 1);
		String idMovie = request.getParameter("id");
		int id = Integer.parseInt(idMovie);

		List<Ticket> tickets = ticketBO.getTickets(pageNumber, 50, id);
		request.setAttribute("tickets", tickets);
		request.getRequestDispatcher("/jsp/Ticket/TicketsList.jsp").forward(request, response);

	}

}
