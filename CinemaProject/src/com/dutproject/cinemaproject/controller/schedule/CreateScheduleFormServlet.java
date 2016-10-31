package com.dutproject.cinemaproject.controller.schedule;

import com.dutproject.cinemaproject.controller.BaseServlet;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CreateScheduleFormServlet
 */
@WebServlet(name = "CreateScheduleForm", urlPatterns = { "/CreateScheduleForm" })
public class CreateScheduleFormServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doWork(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect(request.getContextPath() + "/jsp/schedule/createScheduleForm.jsp");
	}

}
