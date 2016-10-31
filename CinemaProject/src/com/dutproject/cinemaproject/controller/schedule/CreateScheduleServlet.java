package com.dutproject.cinemaproject.controller.schedule;

import com.dutproject.cinemaproject.controller.BaseServlet;
import com.dutproject.cinemaproject.model.bean.schedule.Schedule;
import com.dutproject.cinemaproject.model.bo.schedule.ScheduleBO;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CreateScheduleServlet
 */
@WebServlet(name = "CreateSchedule", urlPatterns = { "/CreateSchedule" })
public class CreateScheduleServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doWork(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*check login with schedule manager account*/
		if (!ScheduleManagementHelper.isLogined(request, response)) {
			request.getRequestDispatcher("/Logout").forward(request, response);
			return;
		}
		
		String str_filmId = request.getParameter("filmId");
		String str_roomId = request.getParameter("roomId");
		String str_date = request.getParameter("date");
		String str_startTime = request.getParameter("startTime");
		String str_endTime = request.getParameter("endTime");
		
		int filmId = Integer.parseInt(str_filmId);
		int roomId = Integer.parseInt(str_roomId);
		int startTime = Integer.parseInt(str_startTime);
		int endTime = Integer.parseInt(str_endTime);
		
		int startTimeInSeconds = 0;
		int endTimeInSeconds = 0;
		
		Schedule schedule = new Schedule(filmId, roomId, startTimeInSeconds, endTimeInSeconds);
		ScheduleBO scheduleBO = new ScheduleBO();
		scheduleBO.createSchedule(schedule);
	}

}
