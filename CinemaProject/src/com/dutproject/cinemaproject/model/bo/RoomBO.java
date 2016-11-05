package com.dutproject.cinemaproject.model.bo;

import java.util.ArrayList;
import java.util.List;

import com.dutproject.cinemaproject.model.bean.Room;
import com.dutproject.cinemaproject.model.dao.RoomDAO;

public class RoomBO {

	RoomDAO roomDAO = new RoomDAO();

	public List<Room> getRooms(int pageNumber, int count) {
		return roomDAO.getRooms(pageNumber, count);
	}

	public boolean checkExistRoomName(String roomName) {
		return roomDAO.getRoomByName(roomName) != null;
	}

	public void addRoom(Room room) {
		roomDAO.addRoom(room);
	}

}
