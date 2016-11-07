package com.dutproject.cinemaproject.controller.schedule;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CreateScheduleForm", urlPatterns = { "/CreateScheduleForm" })
public class CreateScheduleFormServlet extends ScheduleManagerFilterServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("jsp/schedule/createScheduleForm.jsp");
	}

}
