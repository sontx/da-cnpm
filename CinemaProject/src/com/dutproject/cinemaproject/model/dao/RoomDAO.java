package com.dutproject.cinemaproject.model.dao;




import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.dutproject.cinemaproject.model.bean.Room;









public class RoomDAO {
	private Connection con = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	ArrayList<Room> listRoom = null;
	Room room = null;
	
	public ArrayList<Room> getAllRoom() {
		String sql = "SELECT id, stt, maphong, tenphong, sohang, socot WHERE active = 1";		
		listRoom = new ArrayList<Room>();
		
		try {
			con = SQLConnection.getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				room = new Room();
				room.setId(rs.getInt(1));
				room.setStt(rs.getInt(2));
				room.setMaPhong(rs.getString(3));
				room.setTenPhong(rs.getString(4));
				room.setSoHang(rs.getInt(5));
				room.setSoCot(rs.getInt(6));
				
				
				listRoom.add(room);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SQLConnection.closeConnection(this.con);
			SQLConnection.closePrepareStatement(pstmt);
			SQLConnection.closeResultSet(rs);
		}
		return listRoom;
	}

	public Room getRoomTheoStt(int stt) {
		String sql = "SELECT id, stt, maphong, tenphong, sohang, socot, active FROM room_tbl WHERE active = 1 AND stt = ?";		
		
		try {
			con = SQLConnection.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, stt);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				room = new Room();
				room.setId(rs.getInt(1));
				room.setStt(rs.getInt(2));
				room.setMaPhong(rs.getString(3));
				room.setTenPhong(rs.getString(4));
				room.setSoHang(rs.getInt(5));
				room.setSoCot(rs.getInt(6));
			
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SQLConnection.closeConnection(this.con);
			SQLConnection.closePrepareStatement(pstmt);
			SQLConnection.closeResultSet(rs);
		}
		return room;
	}
	public int addRoom(Room room) {
		String sql = "INSERT INTO room_tbl(id, maphong, tenphong, sochongoi, active) VALUES (?,?,?,?,?)";		
		int result = 0;
		try {
			con = SQLConnection.getConnection();
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, room.getId());
			pstmt.setString(2, room.getMaPhong());
			pstmt.setString(3, room.getTenPhong());
			pstmt.setInt(4, room.getSoHang());
			pstmt.setInt(5, room.getSoCot());
			
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SQLConnection.closeConnection(this.con);
			SQLConnection.closePrepareStatement(pstmt);
			SQLConnection.closeResultSet(rs);
		}
		return result;
	}

	public int updateRoom(Room room) {
		String sql = "UPDATE room_tbl SET ten = ?, sochongoi = ?, active = ? WHERE id_room = ?";		
		int result = 0;
		try {
			con = SQLConnection.getConnection();
			pstmt = con.prepareStatement(sql);
			
			
			pstmt.setString(1, room.getTenPhong());
			pstmt.setInt(2, room.getSoHang());
			pstmt.setInt(3, room.getSoCot());
			pstmt.setInt(4, room.getId());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SQLConnection.closeConnection(this.con);
			SQLConnection.closePrepareStatement(pstmt);
			SQLConnection.closeResultSet(rs);
		}
		return result;
	}

	public int deleteRoom(int maphong) {
		String sql = "UPDATE room_tbl SET active = 0 WHERE id_khoa = ?";		
		int result = 0;
		try {
			con = SQLConnection.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, maphong);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SQLConnection.closeConnection(this.con);
			SQLConnection.closePrepareStatement(pstmt);
			SQLConnection.closeResultSet(rs);
		}
		return result;
	}

	
}
