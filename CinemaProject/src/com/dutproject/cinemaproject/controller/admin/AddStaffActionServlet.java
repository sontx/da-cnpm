package com.dutproject.cinemaproject.controller.admin;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dutproject.cinemaproject.model.bean.Account;
import com.dutproject.cinemaproject.model.bean.Staff;
import com.dutproject.cinemaproject.model.bo.AdminBO;
import com.dutproject.cinemaproject.utils.Validate;

@WebServlet(name = "AddStaffAction", urlPatterns = { "/Admin/AddStaffAction" })
public class AddStaffActionServlet extends AdminFilterServlet {
	private static final long serialVersionUID = 1L;
	private AdminBO adminBO = new AdminBO();
	
	@Override
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String fullName = request.getParameter("fullName");
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String birthday = request.getParameter("birthday");
		String phoneNumber = request.getParameter("phoneNumber");
		String identityCard = request.getParameter("identityCard");
		String staffType = request.getParameter("staffType");
		
		if (!adminBO.checkExistUserName(userName)) {
			if (!adminBO.checkExistIdentifyCard(identityCard)) {
				int permission = tryParseInt(staffType, Account.NO_PERMISSION);
				
				Staff staff = new Staff();
				staff.setFullName(fullName);
				staff.setUserName(userName);
				staff.setPassword(password);
				try {
					staff.setBirthDay(Validate.getDateFromString(birthday));
				} catch (ParseException e) {
					e.printStackTrace();
				}
				staff.setPhoneNumber(phoneNumber);
				staff.setIdentityCard(identityCard);
				staff.setPermission(permission);
				
				adminBO.addStaff(staff);
				
				request.setAttribute("page", "StaffsList");
				request.setAttribute("message", "Added susscess!");
				request.getServletContext().getRequestDispatcher("/jsp/Success.jsp").forward(request, response);
			} else {
				request.setAttribute("message", "Identify card already exists");
				request.getServletContext().getRequestDispatcher("/jsp/Error.jsp").forward(request, response);
			}
		} else {
			request.setAttribute("message", "User name already exists");
			request.getServletContext().getRequestDispatcher("/jsp/Error.jsp").forward(request, response);
		}
	}

}
