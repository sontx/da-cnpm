package com.dutproject.cinemaproject.controller.schedule;

import com.dutproject.cinemaproject.model.bean.schedule.Chair;
import com.dutproject.cinemaproject.model.bean.schedule.Schedule;
import com.dutproject.cinemaproject.model.bean.schedule.Ticket;
import com.dutproject.cinemaproject.model.bo.schedule.ChairBO;
import com.dutproject.cinemaproject.model.bo.schedule.ScheduleBO;
import com.dutproject.cinemaproject.model.bo.schedule.TicketBO;
import com.dutproject.cinemaproject.utils.schedule.Converter;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CreateSchedule", urlPatterns = { "/CreateSchedule" })
public class CreateScheduleServlet extends ScheduleManagerFilterServlet {
	private static final long serialVersionUID = 1L;
	private ScheduleBO scheduleBO = new ScheduleBO();

	@Override
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Schedule schedule = getSchedule(request);
		boolean isSuccessful = scheduleBO.createSchedule(schedule);
		
		generateTicket(schedule.getRoomId(), getScheduleId(schedule));
		
		request.setAttribute("isCreatedSuccessfully", isSuccessful);
		request.getRequestDispatcher("/ScheduleManagement").forward(request, response);
	}

	private void generateTicket(int roomId, int scheduleId) {
		ChairBO chairBO = new ChairBO();
		TicketBO ticketBO = new TicketBO();
		List<Chair> listChairs = chairBO.getListChairs(roomId);
		for (Chair c : listChairs) {
			if (c.isAvailable()) {
				ticketBO.createTicket(scheduleId, c.getChairId(), Ticket.DEFAULT_PRICE);
			}
		}
	}

	private int getScheduleId(Schedule schedule) {
		return scheduleBO.getScheduleId(schedule);
	}

	private Schedule getSchedule(HttpServletRequest request) {
		int filmId = getFilmId(request);
		int roomId = getRoomId(request);
		int startTime = getStartTime(request);
		int endTime = getEndTime(request);
		return new Schedule(filmId, roomId, startTime, endTime);
	}

	private int getRoomId(HttpServletRequest request) {
		return Integer.parseInt(request.getParameter("roomId"));
	}

	private int getFilmId(HttpServletRequest request) {
		return Integer.parseInt(request.getParameter("filmId"));
	}

	private int getEndTime(HttpServletRequest request) {
		String str_date = request.getParameter("date");
		String str_endTime = request.getParameter("endTime");
		Date endTime = Converter.stringToDate(str_endTime + " " + str_date);
		return Converter.dateToInt(endTime);
	}

	private int getStartTime(HttpServletRequest request) {
		String str_date = request.getParameter("date");
		String str_startTime = request.getParameter("startTime");
		Date startTime = Converter.stringToDate(str_startTime + " " + str_date);
		return Converter.dateToInt(startTime);
	}

}
