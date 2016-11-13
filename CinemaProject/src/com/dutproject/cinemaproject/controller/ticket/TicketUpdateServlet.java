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
public class TicketUpdateServlet extends TicketFilterServlet {
	private static final long serialVersionUID = 1L;
	private TicketBO ticketBO = new TicketBO();

	@Override
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
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

}
