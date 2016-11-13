//package com.dutproject.cinemaproject.model.dao.test;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import com.dutproject.cinemaproject.model.bean.Movie;
//import com.dutproject.cinemaproject.model.bean.Ticket;
//import com.dutproject.cinemaproject.model.dao.service.ITicketService;
//
//public class TicketTest implements ITicketService {
//	@Override
//	public int getNumberOfTickets() {
//		return 3;
//	}
//
//	@Override
//	public List<Ticket> getTickets(int offset, int count) {
//		List<Ticket> tickets = new ArrayList<>();
//
//		Ticket ticket = new Ticket();
//		ticket.setId(1);
//		ticket.setSeatNumber("A1");
//		ticket.setState("booked");
//		ticket.setDateTime("11:00 20/10/2016");
//		tickets.add(ticket);
//
//		ticket = new Ticket();
//		ticket.setId(2);
//		ticket.setSeatNumber("A2");
//		ticket.setState("booked");
//		ticket.setDateTime("11:00 20/10/2016");
//		tickets.add(ticket);
//
//		ticket = new Ticket();
//		ticket.setId(3);
//		ticket.setSeatNumber("B2");
//		ticket.setState("available");
//		ticket.setDateTime("11:00 20/10/2016");
//		tickets.add(ticket);
//
//		return tickets;
//	}
//
//	@Override
//	public void updateTicketState(Ticket ticket) {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public void updateTicketState(int id, String state) {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public List<Movie> getMovies(int offset, int count) {
//		List<Movie> movies = new ArrayList<>();
//
//		Movie movie = new Movie();
//		movie.setId(1);
//		movie.setNameOfMovie("Train to Busan");
//		movie.setSchedule("11:00 20/10/2016");
//		movies.add(movie);
//
//		movie = new Movie();
//		movie.setId(2);
//		movie.setNameOfMovie("King of rings");
//		movie.setSchedule("19:00 20/10/2016");
//		movies.add(movie);
//
//		return movies;
//
//	}
//
//	@Override
//	public int getNumberOfMovies() {
//		return 2;
//	}
//
//	@Override
//	public String getNameOfMovie(int id) {
//		return "Train to Busan";
//	}
//
//}
