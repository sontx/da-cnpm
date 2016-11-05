package com.dutproject.cinemaproject.model.dao.service;

import java.util.List;

import com.dutproject.cinemaproject.model.bean.Room;

public interface IRoomService {

	List<Room> getRooms(int pageNumber, int count);

	Room getRoomByName(String roomName);

	void addRoom(Room room);

	Room getRoom(int id);

	void updateRoom(Room room);

	void deleteRoom(int id);
	
}
