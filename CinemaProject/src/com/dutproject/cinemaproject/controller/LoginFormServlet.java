package com.dutproject.cinemaproject.controller;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;

/**
 * Servlet implementation class LoginFormServlet
 */
@WebServlet(name = "Login", urlPatterns = { "/Login" })
public class LoginFormServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

    public LoginFormServlet() {
        super();
    }

	@Override
	protected void doWork() throws IOException {
		this.sendRedirect("jsp/loginForm.jsp");
	}

}
