package com.dutproject.cinemaproject.model.bo;





import java.util.ArrayList;

import com.dutproject.cinemaproject.model.bean.Room;
import com.dutproject.cinemaproject.model.dao.RoomDAO;




public class RoomBO {
	
	RoomDAO roomDAO = new RoomDAO();
	
	public ArrayList<Room> getAllRoom() {
		return roomDAO.getAllRoom();
	}
	
	public Room getRoomTheoStt(int stt) {
		return roomDAO.getRoomTheoStt(stt);
	}
	public int addRoom(Room room) {
		return roomDAO.addRoom(room);
	}
	
	public int updateRoom(Room room) {
		return roomDAO.updateRoom(room);
	}
	
	public int deleteRoom(int maphong) {
		return roomDAO.deleteRoom(maphong);
	}
	
	
}
