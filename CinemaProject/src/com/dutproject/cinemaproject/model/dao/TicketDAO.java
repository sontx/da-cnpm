package com.dutproject.cinemaproject.model.dao;

import java.util.List;

import com.dutproject.cinemaproject.model.bean.Movie;
import com.dutproject.cinemaproject.model.bean.Ticket;
import com.dutproject.cinemaproject.model.dao.service.ITicketService;
import com.dutproject.cinemaproject.model.dao.test.TicketTest;

public class TicketDAO implements ITicketService {
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

	@Override
	public void updateTicketState(int id, String state) {
		underlyingService.updateTicketState(id, state);
	}

	@Override
	public void updateTicketState(Ticket ticket) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Movie> getMovies(int offset, int count) {
		return underlyingService.getMovies(offset, count);
	}

	@Override
	public int getNumberOfMovies() {
		return underlyingService.getNumberOfMovies();
	}

	public String getNameOfMovie(int id) {
		return underlyingService.getNameOfMovie(id);
	}
}
