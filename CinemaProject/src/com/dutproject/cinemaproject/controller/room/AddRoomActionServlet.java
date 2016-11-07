package com.dutproject.cinemaproject.controller.room;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dutproject.cinemaproject.model.bean.Room;
import com.dutproject.cinemaproject.model.bo.RoomBO;

@WebServlet(name = "AddRoomAction", urlPatterns = { "/Room/AddRoomAction" })
public class AddRoomActionServlet extends RoomFilterServlet {
	private static final long serialVersionUID = 1L;
	private RoomBO roomBO = new RoomBO();

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String roomName = request.getParameter("roomName");
		String sRows = request.getParameter("rows");
		String sColumns = request.getParameter("columns");

		request.setAttribute("page", "RoomsList");
		if (!roomBO.checkExistRoomName(roomName)) {
			int rows = tryParseInt(sRows, -1);
			int columns = tryParseInt(sColumns, -1);
			Room room = new Room();
			room.setRoomName(roomName);
			room.setRows(rows);
			room.setColumns(columns);
			room.setStatus(0);
			roomBO.addRoom(room);
			request.setAttribute("message", "Added susscess!");
			request.getServletContext().getRequestDispatcher("/jsp/Success.jsp").forward(request, response);
		} else {
			request.setAttribute("message", "User name already exists");
			request.getServletContext().getRequestDispatcher("/jsp/Error.jsp").forward(request, response);
		}
	}

}
