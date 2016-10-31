package com.dutproject.cinemaproject.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dutproject.cinemaproject.model.bean.Account;
import com.dutproject.cinemaproject.model.bean.Account.Permission;
import com.dutproject.cinemaproject.model.bo.AccountBO;

/**
 * Servlet implementation class LoginActionServlet
 */
@WebServlet(name = "LoginAction", urlPatterns = { "/LoginAction" })
public class LoginActionServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

    public LoginActionServlet() {
        super();
    }

	@Override
	protected void doWork(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		Account account = new Account(username, password);
		
		AccountBO accountBO = new AccountBO();
		Account.Permission permission = accountBO.isValidAccount(account);
		if (permission != Account.Permission.NO_PERMISSION) {
			saveUsernameToSession(request.getSession(), account.getUsername());
			savePermissionToSessioin(request.getSession(), permission);
		}
		switch (permission) {
		case FILM_MANAGER:
			response.sendRedirect("jsp/filmManagement.jsp");
			break;
		case ROOM_MANAGER:
			break;
		case SCHEDULE_MANAGER:
			request.getRequestDispatcher("/ScheduleManagement").forward(request, response);
			break;
		case NO_PERMISSION:
			response.sendRedirect("jsp/loginForm.jsp");
			break;
		default:
			break;
		}
	}

	private void savePermissionToSessioin(HttpSession session, Permission permission) {
		session.setAttribute("permission", permission);
	}

	private void saveUsernameToSession(HttpSession session, String username) {
		session.setAttribute("username", username);
	}

}
