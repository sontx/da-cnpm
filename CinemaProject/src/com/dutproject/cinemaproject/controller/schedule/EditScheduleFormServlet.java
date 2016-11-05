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
 * Servlet implementation class EditScheduleFormServlet
 */
@WebServlet(name = "EditScheduleForm", urlPatterns = { "/EditScheduleForm" })
public class EditScheduleFormServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doWork(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		ScheduleBO scheduleBO = new ScheduleBO();
		Schedule schedule = scheduleBO.getScheduleById(id);
		
		request.setAttribute("schedule", schedule);
		request.getRequestDispatcher("/jsp/schedule/editScheduleForm.jsp").forward(request, response);
	}

}
