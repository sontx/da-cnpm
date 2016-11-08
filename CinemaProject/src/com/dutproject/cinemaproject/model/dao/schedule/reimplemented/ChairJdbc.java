package com.dutproject.cinemaproject.model.dao.schedule.reimplemented;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dutproject.cinemaproject.model.bean.schedule.Chair;
import com.dutproject.cinemaproject.model.dao.reimplemented.JdbcService;
import com.dutproject.cinemaproject.model.dao.schedule.service.IChairService;

public class ChairJdbc extends JdbcService implements IChairService {

	@Override
	public List<Chair> getListChairs(int roomId) {
		CallableStatement callable = null;
		try {
			callable = connection.prepareCall("{call schedule_getListChairs(?)}");
			callable.setInt(1, roomId);
			ResultSet rs = callable.executeQuery();
			List<Chair> listChairs = parseResultSetToListChairs(rs);
			rs.close();
			return listChairs;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (callable != null) {
				try {
					callable.close();
				} catch (SQLException e) {}
			}
		}
		return null;
	}

	private List<Chair> parseResultSetToListChairs(ResultSet rs) throws SQLException {
		List<Chair> listChairs = new ArrayList<Chair>();
		while (rs.next()) {
			listChairs.add(parseResultsetToChair(rs));
		}
		return listChairs;
	}

	private Chair parseResultsetToChair(ResultSet rs) throws SQLException {
		int chairId = rs.getInt("chairId");
		int roomId = rs.getInt("roomId");
		String position = rs.getString("position");
		String state = rs.getString("state");
		return new Chair(chairId, roomId, position, state);
	}

}
