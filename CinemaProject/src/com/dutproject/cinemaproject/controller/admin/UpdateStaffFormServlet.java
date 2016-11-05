package com.dutproject.cinemaproject.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dutproject.cinemaproject.model.bean.AccountProfile;
import com.dutproject.cinemaproject.model.bo.AdminBO;

@WebServlet(name = "UpdateStaffForm", urlPatterns = { "/Admin/UpdateStaffForm" })
public class UpdateStaffFormServlet extends AdminFilterServlet {
	private static final long serialVersionUID = 1L;
	private AdminBO adminBO = new AdminBO();
	
	@Override
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sid = request.getParameter("id");
		int staffId = tryParseInt(sid, -1);
		AccountProfile staff = adminBO.getStaff(staffId);
		request.setAttribute("staff", staff);
		request.getServletContext().getRequestDispatcher("/jsp/Admin/UpdateStaffForm.jsp").forward(request, response);
	}

}
