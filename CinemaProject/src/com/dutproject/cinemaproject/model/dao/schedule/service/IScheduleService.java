package com.dutproject.cinemaproject.model.dao.schedule.service;

import java.util.List;

import com.dutproject.cinemaproject.model.bean.schedule.Schedule;

public interface IScheduleService {
	public boolean createSchedule(Schedule schedule);
	public int getNumOfSchedules();
	public List<Schedule> getListSchedules(int pageNumber);
	public boolean deleteScheduleById(int id);
	public boolean updateSchedule(Schedule schedule);
	public Schedule getScheduleById(int id);
	int getScheduleId(Schedule schedule);
}
