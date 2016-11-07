package com.dutproject.cinemaproject.controller.room;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dutproject.cinemaproject.model.bean.AccountProfile;
import com.dutproject.cinemaproject.model.bean.Room;
import com.dutproject.cinemaproject.model.bo.RoomBO;

@WebServlet(name = "RoomsList", urlPatterns = { "/Room/RoomsList" })
public class RoomsListServlet extends RoomFilterServlet {
	private static final long serialVersionUID = 1L;
	private RoomBO roomBO = new RoomBO();
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sPageNumber = request.getParameter("page");
		int pageNumber = tryParseInt(sPageNumber, 1);
		List<Room> rooms = roomBO.getRooms(pageNumber, 50);
		request.setAttribute("rooms", rooms);
		request.getRequestDispatcher("/jsp/Room/RoomsList.jsp").forward(request, response);
	}

}
