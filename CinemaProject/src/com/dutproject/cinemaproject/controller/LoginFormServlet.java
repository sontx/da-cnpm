package com.dutproject.cinemaproject.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginFormServlet
 */
@WebServlet(name = "Login", urlPatterns = { "/Login" })
public class LoginFormServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

    public LoginFormServlet() {
        super();
    }

	@Override
	protected void doWork(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("jsp/loginForm.jsp");
	}

}
