package com.dutproject.cinemaproject.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dutproject.cinemaproject.controller.BaseServlet;
import com.dutproject.cinemaproject.model.bean.Staff;
import com.dutproject.cinemaproject.model.bo.AdminBO;

@WebServlet(name = "UpdateStaffForm", urlPatterns = { "/Admin/UpdateStaffForm" })
public class UpdateStaffFormServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private AdminBO adminBO = new AdminBO();
	
	@Override
	protected void doWork(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sid = request.getParameter("id");
		int staffId = tryParseInt(sid, -1);
		Staff staff = adminBO.getStaff(staffId);
		request.setAttribute("staff", staff);
		request.getRequestDispatcher("/jsp/Admin/UpdateStaffForm.jsp").forward(request, response);
	}

}
