package com.dutproject.cinemaproject.model.bean.schedule;

public class Chair {
	private int chairId;
	private int roomId;
	private String position;
	private String state;
	private static final String STATE_AVAILABLE = "1";

	public Chair(int chairId, int roomId, String position, String state) {
		setChairId(chairId);
		setRoomId(roomId);
		setPosition(position);
		setState(state);
	}

	public int getChairId() {
		return chairId;
	}

	public void setChairId(int chairId) {
		this.chairId = chairId;
	}

	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public boolean isAvailable() {
		return STATE_AVAILABLE.equals(getState());
	}

}
