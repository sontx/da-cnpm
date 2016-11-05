package com.dutproject.cinemaproject.model.dao;

import java.util.List;

import com.dutproject.cinemaproject.model.bean.Room;
import com.dutproject.cinemaproject.model.dao.reimplemented.RoomJdbc;
import com.dutproject.cinemaproject.model.dao.service.IRoomService;

public class RoomDAO implements IRoomService {
	private IRoomService underlyingService = new RoomJdbc();
	
	public List<Room> getRooms(int pageNumber, int count) {
		return underlyingService.getRooms(pageNumber, count);
	}

	public Room getRoomByName(String roomName) {
		return underlyingService.getRoomByName(roomName);
	}

	public void addRoom(Room room) {
		underlyingService.addRoom(room);
	}

}
