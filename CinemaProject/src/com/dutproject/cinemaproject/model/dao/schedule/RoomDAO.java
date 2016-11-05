package com.dutproject.cinemaproject.model.dao.schedule;

import java.util.List;

import com.dutproject.cinemaproject.model.bean.schedule.Room;

public class RoomDAO implements IRoomService {
	IRoomService roomService = new RoomTest();

	@Override
	public Room getRoomById(int roomId) {
		return roomService.getRoomById(roomId);
	}

	@Override
	public List<Room> getAllRooms() {
		return roomService.getAllRooms();
	}

}
