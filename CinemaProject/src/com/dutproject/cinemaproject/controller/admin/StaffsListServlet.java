package com.dutproject.cinemaproject.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dutproject.cinemaproject.model.bean.AccountProfile;
import com.dutproject.cinemaproject.model.bo.AdminBO;

@WebServlet(name = "StaffsList", urlPatterns = { "/Admin/StaffsList" })
public class StaffsListServlet extends AdminFilterServlet {
	private static final long serialVersionUID = 1L;
	private AdminBO adminBO = new AdminBO();

	@Override
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sPageNumber = request.getParameter("page");
		int pageNumber = tryParseInt(sPageNumber, 1);
		List<AccountProfile> staffs = adminBO.getStaffs(pageNumber, 50);
		request.setAttribute("staffs", staffs);
		request.getRequestDispatcher("/jsp/Admin/StaffsList.jsp").forward(request, response);
	}
}
