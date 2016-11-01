package com.dutproject.cinemaproject.controller.scheduleManagement;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dutproject.cinemaproject.controller.BaseServlet;
import com.dutproject.cinemaproject.model.bean.Account;
import com.dutproject.cinemaproject.model.bean.Account.Permission;

/**
 * Servlet implementation class ScheduleManagementServlet
 */
@WebServlet(name = "ScheduleManagement", urlPatterns = { "/ScheduleManagement" })
public class ScheduleManagementServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
    
    public ScheduleManagementServlet() {
        super();
    }

	@Override
	protected void doWork(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*check login and permission*/
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		Account.Permission permission = (Permission) session.getAttribute("permission");
		if (!(isUserLogined(username) && isScheduleManagerPermission(permission))) {
			/*this is not a legal access*/
			/*forward to login page*/
			request.getRequestDispatcher("/Login").forward(request, response);
		}
		
		/*get shedule list and put it into attribute*/
		
		/*forward to schedule management page*/
		request.getRequestDispatcher("jsp/scheduleManagement.jsp").forward(request, response);
	}

	private boolean isScheduleManagerPermission(Permission permission) {
		return Account.Permission.SCHEDULE_MANAGER.equals(permission);
	}

	private boolean isUserLogined(String username) {
		return null != username;
	}

}
