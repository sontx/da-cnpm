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

}
