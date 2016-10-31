package com.dutproject.cinemaproject.model.dao.schedule;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.dutproject.cinemaproject.model.bean.schedule.Schedule;
import com.dutproject.cinemaproject.utils.schedule.Converter;

public class ScheduleTest implements IScheduleService {
	private List<Schedule> listSchedules = new ArrayList<Schedule>();
	
	public ScheduleTest() {
		Date startTime = Converter.stringToDate("10:00 01/01/2011");
		Date endTime = Converter.stringToDate("12:00 01/01/2011");
		listSchedules.add(new Schedule(1, 1, 1, Converter.dateToInt(startTime), Converter.dateToInt(endTime)));
		
		startTime = Converter.stringToDate("10:00 02/01/2011");
		endTime = Converter.stringToDate("12:00 02/01/2011");
		listSchedules.add(new Schedule(2, 2, 2, Converter.dateToInt(startTime), Converter.dateToInt(endTime)));
		
		startTime = Converter.stringToDate("10:00 03/01/2011");
		endTime = Converter.stringToDate("12:00 03/01/2011");
		listSchedules.add(new Schedule(3, 3, 3, Converter.dateToInt(startTime), Converter.dateToInt(endTime)));
	}
	
	@Override
	public boolean createSchedule(Schedule schedule) {
		return false;
	}

	@Override
	public int getNumOfSchedules() {
		return listSchedules.size();
	}

	@Override
	public List<Schedule> getListSchedules(int pageNumber) {
		return listSchedules;
	}

}
