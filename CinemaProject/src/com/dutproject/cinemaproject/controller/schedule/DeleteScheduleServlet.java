package com.dutproject.cinemaproject.controller.schedule;

import com.dutproject.cinemaproject.model.bo.schedule.ScheduleBO;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "DeleteSchedule", urlPatterns = { "/DeleteSchedule" })
public class DeleteScheduleServlet extends ScheduleManagerFilterServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		ScheduleBO scheduleBO = new ScheduleBO();
		boolean isSuccessful = scheduleBO.deleteScheduleById(id);
		request.setAttribute("isDeletedSuccessfully", isSuccessful);
		request.getRequestDispatcher("/ScheduleManagement").forward(request, response);
	}

}
