package com.dutproject.cinemaproject.model.bo.schedule;

import java.math.BigDecimal;

import com.dutproject.cinemaproject.model.dao.schedule.TicketDAO;

public class TicketBO {

	private TicketDAO ticketDAO = new TicketDAO();

	public boolean createTicket(int scheduleId, int chairId, BigDecimal price) {
		return ticketDAO.createTicket(scheduleId, chairId, price);
	}

}
