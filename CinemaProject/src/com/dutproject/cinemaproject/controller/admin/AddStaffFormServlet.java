package com.dutproject.cinemaproject.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dutproject.cinemaproject.controller.BaseServlet;

@WebServlet(name = "AddStaffForm", urlPatterns = { "/Admin/AddStaffForm" })
public class AddStaffFormServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doWork(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/jsp/Admin/AddStaffForm.jsp").forward(request, response);;
	}

}
