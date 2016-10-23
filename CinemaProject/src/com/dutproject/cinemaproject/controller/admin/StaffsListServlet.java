package com.dutproject.cinemaproject.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dutproject.cinemaproject.model.bean.Staff;
import com.dutproject.cinemaproject.model.bo.AdminBO;

@WebServlet(name = "StaffsList", urlPatterns = { "/Admin/StaffsList" })
public class StaffsListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AdminBO adminBO = new AdminBO();

	private int tryParseInt(String st, int defaultValue) {
		try {
			return Integer.parseInt(st);
		} catch (NumberFormatException ignored) {
			return defaultValue;
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sPageNumber = request.getParameter("page");
		int pageNumber = tryParseInt(sPageNumber, 1) - 1;
		List<Staff> staffs = adminBO.getStaffs(pageNumber * 50, 50);
		request.setAttribute("staffs", staffs);
		request.getRequestDispatcher("/jsp/Admin/StaffsList.jsp").forward(request, response);
	}
}
