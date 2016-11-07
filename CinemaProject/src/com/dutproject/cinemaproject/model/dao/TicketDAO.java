package com.dutproject.cinemaproject.model.dao;

import java.util.List;

import com.dutproject.cinemaproject.model.bean.Movie;
import com.dutproject.cinemaproject.model.bean.Ticket;
import com.dutproject.cinemaproject.model.dao.reimplemented.TicketJdbc;
import com.dutproject.cinemaproject.model.dao.service.ITicketService;
//import com.dutproject.cinemaproject.model.dao.test.TicketTest;

public class TicketDAO implements ITicketService {
	private ITicketService underlyingService = new TicketJdbc();
	// private ITicketService underlyingService = new TicketTest();

	@Override
	public int getNumberOfTickets() {
		return underlyingService.getNumberOfTickets();
	}

	@Override
	public List<Ticket> getTickets(int offset, int count, int scheduleId) {
		return underlyingService.getTickets(offset, count, scheduleId);
	}

	@Override
	public void updateTicketState(Ticket ticket) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Movie> getMovies(int offset, int count) {
		return underlyingService.getMovies(offset, count);
	}

	public String getSchedule(int id) {
		return underlyingService.getSchedule(id);
	}
}
