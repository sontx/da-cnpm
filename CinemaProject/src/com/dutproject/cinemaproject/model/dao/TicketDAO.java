package com.dutproject.cinemaproject.model.dao;

import java.util.List;

import com.dutproject.cinemaproject.model.bean.Ticket;
import com.dutproject.cinemaproject.model.dao.service.ITicketService;
import com.dutproject.cinemaproject.model.dao.test.TicketTest;

public class TicketDAO implements ITicketService{
	// private ITicketService underlyingService = new TicketJdbc();
	private ITicketService underlyingService = new TicketTest();

	@Override
	public int getNumberOfTickets() {
		return underlyingService.getNumberOfTickets();
	}

	@Override
	public List<Ticket> getTickets(int offset, int count) {
		return underlyingService.getTickets(offset, count);
	}
}
