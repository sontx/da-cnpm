package com.dutproject.cinemaproject.controller.schedule;

import com.dutproject.cinemaproject.model.bean.schedule.Schedule;
import com.dutproject.cinemaproject.model.bo.schedule.ScheduleBO;
import com.dutproject.cinemaproject.utils.schedule.Converter;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CreateSchedule", urlPatterns = { "/CreateSchedule" })
public class CreateScheduleServlet extends ScheduleManagerFilterServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String str_date = request.getParameter("date");
		String str_startTime = request.getParameter("startTime");
		String str_endTime = request.getParameter("endTime");
		
		int filmId = Integer.parseInt(request.getParameter("filmId"));
		int roomId = Integer.parseInt(request.getParameter("roomId"));
		Date startTime = Converter.stringToDate(str_startTime + " " + str_date);
		Date endTime = Converter.stringToDate(str_endTime + " " + str_date);
		
		int startTimeInSeconds = Converter.dateToInt(startTime);
		int endTimeInSeconds = Converter.dateToInt(endTime);
		
		Schedule schedule = new Schedule(filmId, roomId, startTimeInSeconds, endTimeInSeconds);
		ScheduleBO scheduleBO = new ScheduleBO();
		boolean isSuccessful = scheduleBO.createSchedule(schedule);
		
		request.setAttribute("isCreatedSuccessfully", isSuccessful);
		request.getRequestDispatcher("/ScheduleManagement").forward(request, response);
	}

}
