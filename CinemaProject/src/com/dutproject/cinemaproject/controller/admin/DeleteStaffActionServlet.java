package com.dutproject.cinemaproject.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dutproject.cinemaproject.model.bean.AccountProfile;
import com.dutproject.cinemaproject.model.bo.AdminBO;

@WebServlet(name = "DeleteStaffAction", urlPatterns = { "/Admin/DeleteStaffAction" })
public class DeleteStaffActionServlet extends AdminFilterServlet {
	private static final long serialVersionUID = 1L;
	private AdminBO adminBO = new AdminBO();
	
	@Override
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sId = request.getParameter("id");
		int id = tryParseInt(sId, -1);
		AccountProfile staff = adminBO.getStaff(id);
		request.setAttribute("page", "StaffsList");
		if (staff != null) {
			adminBO.deleteStaff(id);
			request.setAttribute("message", "Removed successful");
			request.getServletContext().getRequestDispatcher("/jsp/Success.jsp").forward(request, response);
		} else {
			request.setAttribute("message", "Staff do not exist");
			request.getServletContext().getRequestDispatcher("/jsp/Error.jsp").forward(request, response);
		}
	}

}
