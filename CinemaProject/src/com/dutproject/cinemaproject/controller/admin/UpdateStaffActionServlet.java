package com.dutproject.cinemaproject.controller.admin;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.dutproject.cinemaproject.model.bean.Account;
import com.dutproject.cinemaproject.model.bean.AccountProfile;
import com.dutproject.cinemaproject.model.bo.AdminBO;
import com.dutproject.cinemaproject.utils.Validate;

@WebServlet(name = "UpdateStaffAction", urlPatterns = { "/Admin/UpdateStaffAction" })
public class UpdateStaffActionServlet extends AdminFilterServlet {
	private static final long serialVersionUID = 1L;
	private AdminBO adminBO = new AdminBO();

	@Override
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sid = request.getParameter("id");
		String fullName = request.getParameter("fullName");
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String birthday = request.getParameter("birthday");
		String phoneNumber = request.getParameter("phoneNumber");
		String identityCard = request.getParameter("identityCard");
		String staffType = request.getParameter("staffType");
		
		request.setAttribute("page", "StaffsList");

		if (adminBO.checkExistUserName(userName)) {
			AccountProfile anotherStaff = adminBO.getStaffByIdentityCard(identityCard);
			if (adminBO.checkExistIdentifyCard(identityCard)) {

				Account account = new Account(userName, password);
				int id = tryParseInt(sid, -1);
				account.setId(id);
				int permission = tryParseInt(staffType, Account.NO_PERMISSION);
				account.setPermission(permission);
				
				AccountProfile staff = new AccountProfile();
				staff.setFullName(fullName);
				staff.setAccount(account);
				try {
					staff.setBirthDay(Validate.getDateFromString(birthday));
				} catch (ParseException e) {
					e.printStackTrace();
				}
				staff.setPhoneNumber(phoneNumber);
				staff.setIdentityCard(identityCard);

				adminBO.updateStaff(staff);

				request.setAttribute("message", "Updated susscess!");
				request.getServletContext().getRequestDispatcher("/jsp/Success.jsp").forward(request, response);
			} else {
				request.setAttribute("message", "Identity card is duplicated with " + anotherStaff.getAccount().getUsername());
				request.getServletContext().getRequestDispatcher("/jsp/Error.jsp").forward(request, response);
			}
		} else {
			request.setAttribute("message", "User name do not exists");
			request.getServletContext().getRequestDispatcher("/jsp/Error.jsp").forward(request, response);
		}
	}

}
