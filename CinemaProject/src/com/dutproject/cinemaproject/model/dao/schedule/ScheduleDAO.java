package com.dutproject.cinemaproject.model.dao.schedule;

import java.util.List;

import com.dutproject.cinemaproject.model.bean.schedule.Schedule;

public class ScheduleDAO implements IScheduleService {
	private IScheduleService scheduleService = new ScheduleTest();

	@Override
	public boolean createSchedule(Schedule schedule) {
		return scheduleService.createSchedule(schedule);
	}

	@Override
	public int getNumOfSchedules() {
		return scheduleService.getNumOfSchedules();
	}

	@Override
	public List<Schedule> getListSchedules(int pageNumber) {
		return scheduleService.getListSchedules(pageNumber);
	}

}