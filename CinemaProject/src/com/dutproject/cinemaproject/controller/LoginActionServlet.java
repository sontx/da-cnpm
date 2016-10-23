package com.dutproject.cinemaproject.controller;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;

import com.dutproject.cinemaproject.model.bean.Account;
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
	protected void doWork() throws IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		Account account = new Account(username, password);
		
		AccountBO accountBO = new AccountBO();
		switch (accountBO.isValidAccount(account)) {
		case FILM_MANAGER:
			this.saveUsernameToSession(account);
			this.sendRedirect("jsp/filmManager.jsp");
			break;
		case ROOM_MANAGER:
			break;
		case NO_PERMISSION:
			this.sendRedirect("jsp/loginForm.jsp");
			break;
		default:
			break;
		}
	}
	
	private void saveUsernameToSession(Account account) {
		this.setAttribute("username", account.getUsername());
	}

}
