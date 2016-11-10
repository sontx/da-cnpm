package com.dutproject.cinemaproject.model.dao.reimplemented;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

import com.dutproject.cinemaproject.model.bean.Account;
import com.dutproject.cinemaproject.model.bean.AccountProfile;
import com.dutproject.cinemaproject.model.bean.Movie;
import com.dutproject.cinemaproject.model.bean.Ticket;
import com.dutproject.cinemaproject.model.dao.service.ITicketService;

public class TicketJdbc extends JdbcService implements ITicketService {
	@Override
	public int getNumberOfTickets(int scheduleId) {
		CallableStatement callable = null;
		try {
			callable = connection.prepareCall("{call ticket_getTicketsCount(?)}");
			ResultSet rs = callable.executeQuery();
			if (rs.next())
				return rs.getInt(1);
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (callable != null) {
				try {
					callable.close();
				} catch (SQLException e) {
				}
			}
		}
		return 0;
	}

	@Override
	public List<Ticket> getTickets(int offset, int count, int scheduleId) {
		CallableStatement callable = null;
		try {
			callable = connection.prepareCall("{call ticket_getTickets(?,?,?)}");
			callable.setInt(1, offset);
			callable.setInt(2, count);
			callable.setInt(3, scheduleId);
			ResultSet rs = callable.executeQuery();
			List<Ticket> tickets = new ArrayList<>();
			while (rs.next()) {
				Ticket ticket = new Ticket();
				ticket.setTicketId(rs.getInt("ticketId"));
				ticket.setScheduleId(rs.getInt("scheduleId"));
				ticket.setChairId(rs.getInt("chairId"));
				ticket.setPrice(rs.getBigDecimal("price"));
				ticket.setState(rs.getString("state"));

				tickets.add(ticket);
			}
			rs.close();
			return tickets;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (callable != null) {
				try {
					callable.close();
				} catch (SQLException e) {
				}
			}
		}
		return null;
	}

	@Override
	public void updateTicketState(int ticketId, String string) {
		CallableStatement callable = null;
		try {
			callable = connection.prepareCall("{call ticket_updateTicket(?,?)}");
			callable.setInt(1, ticketId);
			callable.setString(2, string);
			callable.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (callable != null) {
				try {
					callable.close();
				} catch (SQLException e) {
				}
			}
		}

	}

	@Override
	public List<Movie> getMovies(int offset, int count) {
		CallableStatement callable = null;
		try {
			callable = connection.prepareCall("{call ticket_getSchedules(?,?)}");
			callable.setInt(1, offset);
			callable.setInt(2, count);
			ResultSet rs = callable.executeQuery();
			List<Movie> movies = new ArrayList<>();
			while (rs.next()) {
				Movie movie = new Movie();
				movie.setScheduleId(rs.getInt("scheduleId"));
				movie.setFilmName(rs.getString("filmName"));
				movie.setRoomId(rs.getInt("roomId"));
				movie.setStartTime(rs.getString("startTime"));
				movie.setEndTime(rs.getString("endTime"));

				movies.add(movie);
			}
			rs.close();
			return movies;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (callable != null) {
				try {
					callable.close();
				} catch (SQLException e) {
				}
			}
		}
		return null;
	}

	@Override
	public String getSchedule(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getNumberOfMovies() {
		CallableStatement callable = null;
		try {
			callable = connection.prepareCall("{call ticket_getSchedulesCount}");
			ResultSet rs = callable.executeQuery();
			if (rs.next())
				return rs.getInt(1);
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (callable != null) {
				try {
					callable.close();
				} catch (SQLException e) {
				}
			}
		}
		return 0;
	}
}
