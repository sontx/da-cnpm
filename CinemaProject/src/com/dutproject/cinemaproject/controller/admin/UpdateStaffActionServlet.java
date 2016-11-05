package com.dutproject.cinemaproject.controller.admin;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dutproject.cinemaproject.controller.BaseServlet;
import com.dutproject.cinemaproject.model.bean.Account;
import com.dutproject.cinemaproject.model.bean.Staff;
import com.dutproject.cinemaproject.model.bo.AdminBO;
import com.dutproject.cinemaproject.utils.Validate;

@WebServlet(name = "UpdateStaffAction", urlPatterns = { "/Admin/UpdateStaffAction" })
public class UpdateStaffActionServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private AdminBO adminBO = new AdminBO();

	@Override
	protected void doWork(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sid = request.getParameter("id");
		String fullName = request.getParameter("fullName");
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String birthday = request.getParameter("birthday");
		String phoneNumber = request.getParameter("phoneNumber");
		String identityCard = request.getParameter("identityCard");
		String staffType = request.getParameter("staffType");

		int id = tryParseInt(sid, -1);

		if (adminBO.checkExistUserName(userName)) {
			Staff anotherStaff = adminBO.getStaffByIdentifyCard(identityCard);
			if (anotherStaff == null || anotherStaff.getId() != id) {
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

				adminBO.updateStaff(staff);

				request.setAttribute("message", "Updated susscess!");
				request.getServletContext().getRequestDispatcher("/jsp/Success.jsp").forward(request, response);
			} else {
				request.setAttribute("message", "Identity card is duplicated with " + anotherStaff.getUserName());
				request.getServletContext().getRequestDispatcher("/jsp/Error.jsp").forward(request, response);
			}
		} else {
			request.setAttribute("message", "User name do not exists");
			request.getServletContext().getRequestDispatcher("/jsp/Error.jsp").forward(request, response);
		}
	}

}