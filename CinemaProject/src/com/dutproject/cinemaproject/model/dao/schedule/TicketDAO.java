package com.dutproject.cinemaproject.model.dao.schedule;

import java.math.BigDecimal;

import com.dutproject.cinemaproject.model.dao.schedule.reimplemented.TicketJdbc;
import com.dutproject.cinemaproject.model.dao.schedule.service.ITicketService;

public class TicketDAO implements ITicketService{
	
	private ITicketService ticketService = new TicketJdbc();

	@Override
	public boolean createTicket(int scheduleId, int chairId, BigDecimal price) {
		return ticketService.createTicket(scheduleId, chairId, price);
	}

}
