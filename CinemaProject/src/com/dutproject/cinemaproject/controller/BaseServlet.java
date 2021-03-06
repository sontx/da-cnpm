package com.dutproject.cinemaproject.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdminServlet
 */
public abstract class BaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected int tryParseInt(String st, int defaultValue) {
		try {
			return Integer.parseInt(st);
		} catch (NumberFormatException ignored) {
			return defaultValue;
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doWork(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doWork(request, response);
	}
	
	protected abstract void doWork(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
	
	protected final void showErrorMessage(String message, String page, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("message", message);
		request.setAttribute("page", page);
		request.getServletContext().getRequestDispatcher("/jsp/Error.jsp").forward(request, response);
	}
	
	protected final void showSuccessMessage(String message, String page, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("message", message);
		request.setAttribute("page", page);
		request.getServletContext().getRequestDispatcher("/jsp/Success.jsp").forward(request, response);
	}
}
