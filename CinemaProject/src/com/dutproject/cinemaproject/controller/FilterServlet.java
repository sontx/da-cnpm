package com.dutproject.cinemaproject.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class FilterServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	protected abstract int getServletPermission();

	private boolean checkPermission(HttpServletRequest request) {
		Object objPermission = request.getSession().getAttribute("permission");
		if (objPermission != null) {
			int permission = (int) objPermission;
			if (permission == getServletPermission())
				return true;
		}
		return false;
	}

	protected abstract void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException;

	@Override
	protected final void doWork(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (checkPermission(request))
			processRequest(request, response);
		else
			navigateToLogin(request, response);
	}

	private void navigateToLogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("/CinemaProject/Login");
	}
}
