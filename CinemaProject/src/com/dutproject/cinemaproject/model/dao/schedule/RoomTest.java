package com.dutproject.cinemaproject.model.dao.schedule;

import java.util.ArrayList;
import java.util.List;

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

	@Override
	public List<Room> getAllRooms() {
		List<Room> listRooms = new ArrayList<Room>();
		listRooms.add(new Room(1, "Phong 1"));
		listRooms.add(new Room(2, "Phong 2"));
		listRooms.add(new Room(3, "Phong 3"));
		return listRooms;
	}

}
