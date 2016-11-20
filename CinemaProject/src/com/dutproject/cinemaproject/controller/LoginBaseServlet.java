package com.dutproject.cinemaproject.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dutproject.cinemaproject.model.bean.Account;

public abstract class LoginBaseServlet extends BaseServlet {

	protected int getPermission(HttpServletRequest request) {
		Object objPermission = request.getSession().getAttribute("permission");
		String spermission = objPermission != null ? objPermission.toString() : Account.NO_PERMISSION + "";
		int permission = Account.NO_PERMISSION;
		try {
			permission = Integer.parseInt(spermission);
		} catch (NumberFormatException ignored) {
		}
		return permission;
	}

	protected void navigateToHome(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int permission = getPermission(request);

		String site = "Login";
		String home = "Login";
		switch (permission) {
		case Account.ACCOUNT_MANAGER:
			site = "Admin/StaffsList";
			home = "StaffsList";
			break;
		case Account.FILM_MANAGER:
			site = "film/FilmList";
			home = "FilmList";
			break;
		case Account.ROOM_MANAGER:
			site = "Room/RoomsList";
			home = "RoomsList";
			break;
		case Account.SCHEDULE_MANAGER:
			site = "ScheduleManagement";
			home = "ScheduleManagement";
			break;
		case Account.TICKET_MANAGER:
			site = "MovieListServlet";
			home = "MovieListServlet";
			break;
		case Account.NO_PERMISSION:
			break;
		default:
			break;
		}
		if (permission != Account.NO_PERMISSION)
			request.getSession().setAttribute("home", home);
		response.sendRedirect(site);
	}
}
