package com.dutproject.cinemaproject.model.dao.schedule;

import java.util.List;

import com.dutproject.cinemaproject.model.bean.schedule.Room;
import com.dutproject.cinemaproject.model.dao.schedule.reimplemented.RoomJdbc;
import com.dutproject.cinemaproject.model.dao.schedule.service.IRoomService;

public class RoomDAO implements IRoomService {
//	IRoomService roomService = new RoomTest();
	private IRoomService roomService = new RoomJdbc();

	@Override
	public Room getRoomById(int roomId) {
		return roomService.getRoomById(roomId);
	}

	@Override
	public List<Room> getAllRooms() {
		return roomService.getAllRooms();
	}

}
