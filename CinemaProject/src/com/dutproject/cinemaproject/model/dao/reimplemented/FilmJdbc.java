package com.dutproject.cinemaproject.model.dao.reimplemented;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.dutproject.cinemaproject.model.bean.Film;
import com.dutproject.cinemaproject.model.dao.service.IShowFilmService;

public class FilmJdbc extends JdbcService implements  IShowFilmService  {

	@Override
	public int getNumberOfFilms() {
		String sql = "SELECT COUNT(*) FROM Film";
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
	public List<Film> getFilms(int offset, int count) {
		// TODO Auto-generated method stub
		return null;
	}

}
