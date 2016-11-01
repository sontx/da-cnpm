package com.dutproject.cinemaproject.model.bean.schedule;

public class Room {
	private int roomId;
	private String roomName;
	
	public Room() {
	}
	
	public Room(int roomId, String roomName) {
		setRoomId(roomId);
		setRoomName(roomName);
	}

	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	
}
