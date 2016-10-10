package com.dutproject.cinemaproject.controller;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;

/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet(name = "Logout", urlPatterns = { "/Logout" })
public class LogoutServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

    public LogoutServlet() {
        super();
    }

	@Override
	protected void doWork() throws IOException {
		this.request.getSession().invalidate();
		this.sendRedirect("jsp/loginForm.jsp");
	}

}
