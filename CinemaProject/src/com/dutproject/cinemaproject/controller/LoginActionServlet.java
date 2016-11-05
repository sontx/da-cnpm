package com.dutproject.cinemaproject.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dutproject.cinemaproject.model.bean.Account;
import com.dutproject.cinemaproject.model.bo.AccountBO;

/**
 * Servlet implementation class LoginActionServlet
 */
@WebServlet(name = "LoginAction", urlPatterns = { "/LoginAction" })
public class LoginActionServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doWork(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		Account account = new Account(username, password);
		
		AccountBO accountBO = new AccountBO();
		int permission = accountBO.isValidAccount(account);
		
		if (Account.NO_PERMISSION != permission) {
			/*save user name to session with management account*/
			request.getSession().setAttribute("username", account.getUsername());
			
			/*save permission to session with management account*/
			request.getSession().setAttribute("permission", permission);
		}
		
		switch (permission) {
		case Account.ACCOUNT_MANAGER:
			break;
		case Account.FILM_MANAGER:
			break;
		case Account.ROOM_MANAGER:
			break;
		case Account.SCHEDULE_MANAGER:
			
			break;
		case Account.TICKET_MANAGER:
			break;
		case Account.NO_PERMISSION:
			request.getRequestDispatcher("jsp/loginForm.jsp").forward(request, response);
			break;
		default:
			break;
		}
	}
	
}
