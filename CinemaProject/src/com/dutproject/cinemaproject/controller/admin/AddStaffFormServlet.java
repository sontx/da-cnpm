package com.dutproject.cinemaproject.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AddStaffForm", urlPatterns = { "/Admin/AddStaffForm" })
public class AddStaffFormServlet extends AdminFilterServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/jsp/Admin/AddStaffForm.jsp").forward(request, response);;
	}

}
