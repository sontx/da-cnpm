package com.dutproject.cinemaproject.controller.ticket;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dutproject.cinemaproject.model.bo.TicketBO;

/**
 * Servlet implementation class TicketUpdateServlet
 */
@WebServlet("/TicketUpdateServlet")
public class TicketUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TicketBO ticketBO = new TicketBO();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TicketUpdateServlet() {
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int ticketId = Integer.parseInt(request.getParameter("id"));
		int scheduleId = Integer.parseInt(request.getParameter("scheduleId"));
		String ticketState = request.getParameter("state");
		if (ticketState.equals("available")) {
			ticketBO.updateTicketState(ticketId, "booked");
		} else {
			ticketBO.updateTicketState(ticketId, "available");
		}
		response.sendRedirect("/CinemaProject/TicketListServlet?id=" + scheduleId);
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
