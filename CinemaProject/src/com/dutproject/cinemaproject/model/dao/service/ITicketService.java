package com.dutproject.cinemaproject.model.dao.service;

import java.util.List;

import com.dutproject.cinemaproject.model.bean.Movie;
import com.dutproject.cinemaproject.model.bean.Ticket;

public interface ITicketService {
	int getNumberOfTickets();

	List<Ticket> getTickets(int offset, int count, int scheduleId);
	
	void updateTicketState(int ticketId, String string);
	
	List <Movie> getMovies (int offset, int count);

	String getSchedule(int id);
}
