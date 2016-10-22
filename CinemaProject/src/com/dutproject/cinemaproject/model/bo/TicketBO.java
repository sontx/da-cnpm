package com.dutproject.cinemaproject.model.bo;

import java.util.List;

import com.dutproject.cinemaproject.model.bean.Ticket;
import com.dutproject.cinemaproject.model.dao.TicketDAO;

public class TicketBO {
	private TicketDAO ticketDAO = new TicketDAO();
	public List<Ticket> getTickets(int offset, int count) {
		return ticketDAO.getTickets(offset, count);
	}
}
