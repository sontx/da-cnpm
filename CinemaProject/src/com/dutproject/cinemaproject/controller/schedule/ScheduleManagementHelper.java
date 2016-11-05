package com.dutproject.cinemaproject.controller.schedule;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dutproject.cinemaproject.model.bean.Account;
import com.dutproject.cinemaproject.model.bean.Account.Permission;

public class ScheduleManagementHelper {
	public static boolean isLogined(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		Account.Permission permission = (Permission) session.getAttribute("permission");
		boolean isLoginedWithValidAccount = null != username;
		boolean isProperPermissionAccess = Permission.SCHEDULE_MANAGER == permission;
		return isLoginedWithValidAccount && isProperPermissionAccess;
	}
}
