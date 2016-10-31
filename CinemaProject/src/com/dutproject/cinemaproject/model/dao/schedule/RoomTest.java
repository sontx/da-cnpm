package com.dutproject.cinemaproject.model.dao.schedule;

import com.dutproject.cinemaproject.model.bean.schedule.Room;

public class RoomTest implements IRoomService {
	
	@Override
	public Room getRoomById(int roomId) {
		switch (roomId) {
		case 1: return new Room(1, "Phong 1");
		case 2: return new Room(2, "Phong 2");
		case 3: return new Room(3, "Phong 3");
		}
		return null;
	}

}
