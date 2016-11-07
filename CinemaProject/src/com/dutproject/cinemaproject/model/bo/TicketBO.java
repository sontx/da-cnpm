package com.dutproject.cinemaproject.model.bo;

import java.util.List;

import com.dutproject.cinemaproject.model.bean.Movie;
import com.dutproject.cinemaproject.model.bean.Ticket;
import com.dutproject.cinemaproject.model.dao.TicketDAO;

public class TicketBO {
	private TicketDAO ticketDAO = new TicketDAO();

	public List<Ticket> getTickets(int offset, int count, int scheduleId) {
		return ticketDAO.getTickets(offset, count, scheduleId);
	}

	public List<Movie> getMovies(int offset, int count) {
		return ticketDAO.getMovies(offset, count);
	}

	public String getSchedule(int id) {
		return ticketDAO.getSchedule(id);
	}

	public void updateTicketState(int ticketId, String string) {
		ticketDAO.updateTicketState(ticketId, string);
		
	}

}
