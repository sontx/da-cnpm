package com.dutproject.cinemaproject.controller.schedule;

import com.dutproject.cinemaproject.controller.BaseServlet;
import com.dutproject.cinemaproject.model.bean.schedule.Schedule;
import com.dutproject.cinemaproject.model.bo.schedule.ScheduleBO;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ScheduleManagementServlet
 */
@WebServlet(name = "ScheduleManagement", urlPatterns = { "/ScheduleManagement" })
public class ScheduleManagementServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	public static int MAX_SCHEDULE_PER_PAGE = 20;
	
	private ScheduleBO scheduleBO = new ScheduleBO();

	@Override
	protected void doWork(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*check login with schedule manager account*/
		if (!ScheduleManagementHelper.isLogined(request, response)) {
			request.getRequestDispatcher("/Logout").forward(request, response);
			return;
		}
		
		int pageNumber = getPageNumber(request);
		int maxPageNumber = getMaxPageNumber();
		List<Schedule> listSchedules = scheduleBO.getListSchedules(pageNumber);
		
		request.setAttribute("pageNumber", pageNumber);
		request.setAttribute("maxPageNumber", maxPageNumber);
		request.setAttribute("listSchedules", listSchedules);
		
		request.getRequestDispatcher("jsp/schedule/scheduleManagement.jsp").forward(request, response);
	}

	private int getPageNumber(HttpServletRequest request) {
		String str_pageNumber = request.getParameter("pageNumber");
		int pageNumber;
		try {
			pageNumber = Integer.parseInt(str_pageNumber);
		} catch (Exception e) {
			pageNumber = 1;
		}
		
		if (pageNumber <= 0) {
			pageNumber = 1;
		}

		int maxPageNumber = getMaxPageNumber();
		if (pageNumber > maxPageNumber) {
			pageNumber = maxPageNumber;
		}
				
		return pageNumber;
	}

	private int getMaxPageNumber() {
		int numOfSchedules = scheduleBO.getNumOfSchedules();
		return numOfSchedules / MAX_SCHEDULE_PER_PAGE + 1;
	}

}
