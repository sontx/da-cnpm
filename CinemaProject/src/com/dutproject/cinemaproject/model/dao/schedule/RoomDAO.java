package com.dutproject.cinemaproject.model.dao.schedule;

import com.dutproject.cinemaproject.model.bean.schedule.Room;

public class RoomDAO implements IRoomService {
	IRoomService roomService = new RoomTest();

	@Override
	public Room getRoomById(int roomId) {
		return roomService.getRoomById(roomId);
	}

}
