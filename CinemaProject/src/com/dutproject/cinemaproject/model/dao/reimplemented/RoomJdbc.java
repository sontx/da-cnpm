package com.dutproject.cinemaproject.model.dao.reimplemented;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dutproject.cinemaproject.model.bean.Room;
import com.dutproject.cinemaproject.model.dao.service.IRoomService;

public class RoomJdbc extends JdbcService implements IRoomService {

	@Override
	public List<Room> getRooms(int pageNumber, int count) {
		CallableStatement callable = null;
		try {
			callable = connection.prepareCall("{call room_getRooms(?,?)}");
			callable.setInt(1, pageNumber);
			callable.setInt(2, count);
			ResultSet rs = callable.executeQuery();
			List<Room> rooms = new ArrayList<>();
			while (rs.next()) {
				Room room = new Room();
				room.setId(rs.getInt("roomId"));
				room.setRoomName(rs.getString("roomName"));
				room.setColumns(rs.getInt("columns"));
				room.setRows(rs.getInt("rows"));
				room.setStatus(rs.getInt("status"));
				rooms.add(room);
			}
			rs.close();
			return rooms;
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
	public Room getRoomByName(String roomName) {
		CallableStatement callable = null;
		try {
			callable = connection.prepareCall("{call room_getRoomByName(?)}");
			callable.setString(1, roomName);
			ResultSet rs = callable.executeQuery();
			if (rs.next()) {
				Room room = new Room();
				room.setId(rs.getInt("roomId"));
				room.setRoomName(rs.getString("roomName"));
				room.setColumns(rs.getInt("columns"));
				room.setRows(rs.getInt("rows"));
				room.setStatus(rs.getInt("status"));
				rs.close();
				return room;
			}
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
		return null;
	}

	@Override
	public void addRoom(Room room) {
		CallableStatement callable = null;
		try {
			callable = connection.prepareCall("{call room_addRoom(?,?,?,?)}");
			callable.setString(1, room.getRoomName());
			callable.setInt(2, room.getRows());
			callable.setInt(3, room.getColumns());
			callable.setInt(4, room.getStatus());
			callable.executeUpdate();
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
	}

	@Override
	public Room getRoom(int id) {
		CallableStatement callable = null;
		try {
			callable = connection.prepareCall("{call room_getRoomById(?)}");
			callable.setInt(1, id);
			ResultSet rs = callable.executeQuery();
			if (rs.next()) {
				Room room = new Room();
				room.setId(rs.getInt("roomId"));
				room.setRoomName(rs.getString("roomName"));
				room.setColumns(rs.getInt("columns"));
				room.setRows(rs.getInt("rows"));
				room.setStatus(rs.getInt("status"));
				rs.close();
				return room;
			}
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
		return null;
	}

	@Override
	public void updateRoom(Room room) {
		CallableStatement callable = null;
		try {
			callable = connection.prepareCall("{call room_updateRoom(?,?,?,?,?)}");
			callable.setInt(1, room.getId());
			callable.setString(2, room.getRoomName());
			callable.setInt(3, room.getRows());
			callable.setInt(4, room.getColumns());
			callable.setInt(5, room.getStatus());
			callable.executeUpdate();
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
	}

	@Override
	public void deleteRoom(int id) {
		CallableStatement callable = null;
		try {
			callable = connection.prepareCall("{call room_deleteRoom(?)}");
			callable.setInt(1, id);
			callable.executeUpdate();
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

	}

}
