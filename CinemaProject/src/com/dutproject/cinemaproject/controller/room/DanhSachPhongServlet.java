package com.dutproject.cinemaproject.controller.room;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dutproject.cinemaproject.model.bean.Room;
import com.dutproject.cinemaproject.model.bo.RoomBO;

/**
 * Servlet implementation class DanhSachKhoaServlet
 */

public class DanhSachPhongServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DanhSachPhongServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");

		// getParameter
		String action = request.getParameter("action");
		String maPhongPr = request.getParameter("id");

		// BO
		RoomBO roomBO = new RoomBO();

		// Object
		ArrayList<Room> listRoom = null;
		Room room = null;

		// kiem tra action
		if (action == null) {

			listRoom = roomBO.getAllRoom();

			request.setAttribute("listRoom", listRoom);

			RequestDispatcher rd = request.getRequestDispatcher("/ds-phong.jsp");
			rd.forward(request, response);

		}

	}

}
