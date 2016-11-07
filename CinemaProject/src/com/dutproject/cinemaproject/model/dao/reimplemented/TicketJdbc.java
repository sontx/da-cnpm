package com.dutproject.cinemaproject.model.dao.reimplemented;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dutproject.cinemaproject.model.bean.Movie;
import com.dutproject.cinemaproject.model.bean.Ticket;
import com.dutproject.cinemaproject.model.dao.service.ITicketService;

public class TicketJdbc extends JdbcService implements ITicketService {
	@Override
	public int getNumberOfTickets() {
		String sql = "SELECT COUNT * FROM ticket";
		Statement statement = null;
		try {
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			if (resultSet.next())
				return resultSet.getInt(1);
			resultSet.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
				}
			}
		}
		return 0;
	}

	@Override
	public List<Ticket> getTickets(int offset, int count) {
		List<Ticket> tickets = new ArrayList<>();
		return null;
	}

	@Override
	public void updateTicketState(int id, String state) {
		String sql = "UPDATE ticket SET state = " + state + "WHERE id = " + id;
		Statement statement = null;
		try {
			statement = connection.createStatement();
			statement.executeUpdate(sql);
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
				}
			}
		}
	}

	@Override
	public void updateTicketState(Ticket ticket) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Movie> getMovies(int offset, int count) {
		List<Movie> movies = new ArrayList<>();
		return null;
	}

	@Override
	public int getNumberOfMovies() {
		String sql = "SELECT COUNT * FROM movie";
		Statement statement = null;
		try {
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			if (resultSet.next())
				return resultSet.getInt(1);
			resultSet.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
				}
			}
		}
		return 0;
	}

	@Override
	public String getNameOfMovie(int id) {
		return null;
	}
}
