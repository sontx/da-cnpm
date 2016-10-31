package com.dutproject.cinemaproject.model.bean.schedule;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.dutproject.cinemaproject.utils.schedule.Converter;

public class Schedule {
	private int scheduleId;
	private int filmId;
	private int roomId;
	private int startTime;
	private int endTime;
	
	public Schedule() {
	}

	public Schedule(int filmId, int roomId, int startTimeInSeconds, int endTimeInSeconds) {
		setFilmId(filmId);
		setRoomId(roomId);
		setStartTime(startTimeInSeconds);
		setEndTime(endTimeInSeconds);
	}
	
	public Schedule(int scheduleId, int filmId, int roomId, int startTimeInSeconds, int endTimeInSeconds) {
		this(filmId, roomId, startTimeInSeconds, endTimeInSeconds);
		setScheduleId(scheduleId);
	}
	
	public String periodOfTimeToString() {
		SimpleDateFormat startTimeFormat = new SimpleDateFormat("HH:mm");
		SimpleDateFormat endTimeFormat = new SimpleDateFormat("HH:mm dd/MM/yyyy");
		Date _startTime = Converter.intToDate(startTime);
		Date _endTime = Converter.intToDate(endTime);
		String format = "%s - %s";
		String periodOfTime = String.format(format, startTimeFormat.format(_startTime), endTimeFormat.format(_endTime));
		return periodOfTime;
	}
	
	public int getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(int scheduleId) {
		this.scheduleId = scheduleId;
	}

	public int getFilmId() {
		return filmId;
	}

	public void setFilmId(int filmId) {
		this.filmId = filmId;
	}

	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public int getStartTime() {
		return startTime;
	}

	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}

	public int getEndTime() {
		return endTime;
	}

	public void setEndTime(int endTime) {
		this.endTime = endTime;
	}

	public void updateInfo(Schedule schedule) {
		setFilmId(schedule.getFilmId());
		setRoomId(schedule.getRoomId());
		setStartTime(schedule.getStartTime());
		setEndTime(schedule.getEndTime());
	}

}
