package com.dutproject.cinemaproject.model.dao.schedule;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dutproject.cinemaproject.model.bean.schedule.Room;
import com.dutproject.cinemaproject.model.dao.reimplemented.JdbcService;

public class RoomJdbc extends JdbcService implements IRoomService {

	@Override
	public Room getRoomById(int roomId) {
		CallableStatement callable = null;
		try {
			callable = connection.prepareCall("{call schedule_getRoomById(?)}");
			callable.setInt(1, roomId);
			ResultSet rs = callable.executeQuery();
			Room room = null;
			if (rs.next()) {
				room = parseResultSetToRoom(rs);
			}
			rs.close();
			return room;
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

	private Room parseResultSetToRoom(ResultSet rs) throws SQLException {
		return new Room(rs.getInt("roomId"), rs.getString("roomName"));
	}

	@Override
	public List<Room> getAllRooms() {
		CallableStatement callable = null;
		try {
			callable = connection.prepareCall("{call schedule_getAllRooms}");
			ResultSet rs = callable.executeQuery();
			List<Room> listRooms = parseResultSetToListRooms(rs);
			rs.close();
			return listRooms;
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

	private List<Room> parseResultSetToListRooms(ResultSet rs) throws SQLException {
		List<Room> listRooms = new ArrayList<Room>();
		while (rs.next()) {
			listRooms.add(parseResultSetToRoom(rs));
		}
		return listRooms;
	}

}
