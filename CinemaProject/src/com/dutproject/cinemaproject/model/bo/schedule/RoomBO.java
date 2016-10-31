package com.dutproject.cinemaproject.model.bo.schedule;

import com.dutproject.cinemaproject.model.bean.schedule.Room;
import com.dutproject.cinemaproject.model.dao.schedule.RoomDAO;

public class RoomBO {
	private RoomDAO roomDAO = new RoomDAO();
	
	public Room getRoomById(int roomId) {
		return roomDAO.getRoomById(roomId);
	}
}
