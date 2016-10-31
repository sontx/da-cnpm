package com.dutproject.cinemaproject.model.bo.schedule;

import java.util.List;

import com.dutproject.cinemaproject.model.bean.schedule.Schedule;
import com.dutproject.cinemaproject.model.dao.schedule.ScheduleDAO;

public class ScheduleBO {
	private ScheduleDAO scheduleDAO = new ScheduleDAO();

	public boolean createSchedule(Schedule schedule) {
		return scheduleDAO.createSchedule(schedule);
	}

	public int getNumOfSchedules() {
		return scheduleDAO.getNumOfSchedules();
	}

	public List<Schedule> getListSchedules(int pageNumber) {
		return scheduleDAO.getListSchedules(pageNumber);
	}

	public boolean deleteScheduleById(int id) {
		return scheduleDAO.deleteScheduleById(id);
	}

}
