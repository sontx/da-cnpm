package com.dutproject.cinemaproject.model.bean;

public class Movie {
	private int scheduleId;
	private String filmName;
	private int roomId;
	private String startTime;
	private String endTime;
	
	
	public Movie() {
		
	}


	public Movie(int scheduleId, String filmName, int roomId, String startTime, String endTime) {
		super();
		this.scheduleId = scheduleId;
		this.filmName = filmName;
		this.roomId = roomId;
		this.startTime = startTime;
		this.endTime = endTime;
	}


	public int getScheduleId() {
		return scheduleId;
	}


	public void setScheduleId(int scheduleId) {
		this.scheduleId = scheduleId;
	}


	public String getFilmName() {
		return filmName;
	}


	public void setFilmName(String filmName) {
		this.filmName = filmName;
	}


	public int getRoomId() {
		return roomId;
	}


	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}


	public String getStartTime() {
		return startTime;
	}


	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}


	public String getEndTime() {
		return endTime;
	}


	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	
	


}
