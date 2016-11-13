package com.dutproject.cinemaproject.model.dao.schedule;

import java.util.List;

import com.dutproject.cinemaproject.model.bean.schedule.Schedule;
import com.dutproject.cinemaproject.model.dao.schedule.reimplemented.ScheduleJdbc;
import com.dutproject.cinemaproject.model.dao.schedule.service.IScheduleService;

public class ScheduleDAO implements IScheduleService {
//	private IScheduleService scheduleService = ScheduleTest.getInstance();
	private IScheduleService scheduleService = new ScheduleJdbc();

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

	@Override
	public boolean deleteScheduleById(int id) {
		return scheduleService.deleteScheduleById(id);
	}

	@Override
	public boolean updateSchedule(Schedule schedule) {
		return scheduleService.updateSchedule(schedule);
	}

	@Override
	public Schedule getScheduleById(int id) {
		return scheduleService.getScheduleById(id);
	}

	@Override
	public int getScheduleId(Schedule schedule) {
		return scheduleService.getScheduleId(schedule);
	}

}
