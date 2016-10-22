package com.dutproject.cinemaproject.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import com.dutproject.cinemaproject.controller.BaseServlet;
import com.dutproject.cinemaproject.model.bean.Staff;
import com.dutproject.cinemaproject.model.bo.AdminBO;

@WebServlet("/StaffsListServlet")
public class StaffsListServlet extends BaseServlet {
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
	protected void doWork() throws IOException, ServletException {
		String sPageNumber = request.getParameter("page");
		int pageNumber = tryParseInt(sPageNumber, 1) - 1;
		List<Staff> staffs = adminBO.getStaffs(pageNumber * 50, 50);
		request.setAttribute("staffs", staffs);
		request.getRequestDispatcher("").forward(request, response);
	}

}
