package com.dutproject.cinemaproject.controller.schedule;

import com.dutproject.cinemaproject.controller.BaseServlet;
import com.dutproject.cinemaproject.model.bo.schedule.ScheduleBO;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteScheduleServlet
 */
@WebServlet(name = "DeleteSchedule", urlPatterns = { "/DeleteSchedule" })
public class DeleteScheduleServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doWork(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		ScheduleBO scheduleBO = new ScheduleBO();
		boolean isSuccessful = scheduleBO.deleteScheduleById(id);
		request.setAttribute("isDeletedSuccessfully", isSuccessful);
		request.getRequestDispatcher("/ScheduleManagement").forward(request, response);
	}

}
