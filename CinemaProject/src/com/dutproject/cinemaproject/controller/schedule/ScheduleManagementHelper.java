package com.dutproject.cinemaproject.controller.schedule;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dutproject.cinemaproject.model.bean.Account;

public class ScheduleManagementHelper {
	public static boolean isLogined(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		int permission = (int) session.getAttribute("permission");
		boolean isLoginedWithValidAccount = null != username;
		boolean isProperPermissionAccess = Account.SCHEDULE_MANAGER == permission;
		return isLoginedWithValidAccount && isProperPermissionAccess;
	}
}
