package com.dutproject.cinemaproject.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dutproject.cinemaproject.model.bean.Account;

/**
 * Servlet implementation class LoginFormServlet
 */
@WebServlet(name = "Login", urlPatterns = { "/Login" })
public class LoginFormServlet extends LoginBaseServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doWork(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (getPermission(request) == Account.NO_PERMISSION)
			request.getServletContext().getRequestDispatcher("/jsp/loginForm.jsp").forward(request, response);
		else
			navigateToHome(request, response);
	}

}
