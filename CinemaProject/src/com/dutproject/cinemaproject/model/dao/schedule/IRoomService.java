package com.dutproject.cinemaproject.model.dao.schedule;

import java.util.List;

import com.dutproject.cinemaproject.model.bean.schedule.Room;

public interface IRoomService {
	
	public Room getRoomById(int roomId);
	public List<Room> getAllRooms();
	
}
