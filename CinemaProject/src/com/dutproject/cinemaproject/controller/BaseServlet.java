package com.dutproject.cinemaproject.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdminServlet
 */
public abstract class BaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected HttpServletResponse response;
	protected HttpServletRequest request;

    public BaseServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.init(request, response);
		this.doWork();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.init(request, response);
		this.doWork();
	}
	
	protected abstract void doWork() throws IOException;
	
	protected void setAttribute(String attributeName, Object attributeValue) {
		request.getSession().setAttribute(attributeName, attributeValue);
	}
	
	protected void sendRedirect(String url) throws IOException {
		this.response.sendRedirect(url);
	}
	
	private void init(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
	}

}
