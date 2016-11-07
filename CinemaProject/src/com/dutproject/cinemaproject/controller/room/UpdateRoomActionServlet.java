package com.dutproject.cinemaproject.controller.room;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dutproject.cinemaproject.model.bean.Room;
import com.dutproject.cinemaproject.model.bo.RoomBO;

@WebServlet(name = "UpdateRoomAction", urlPatterns = { "/Room/UpdateRoomAction" })
public class UpdateRoomActionServlet extends RoomFilterServlet {
	private static final long serialVersionUID = 1L;
	private RoomBO roomBO = new RoomBO();

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sId = request.getParameter("id");
		String roomName = request.getParameter("roomName");
		String sRows = request.getParameter("rows");
		String sColumns = request.getParameter("columns");
		String sChecked = request.getParameter("status");
		int id = tryParseInt(sId, -1);
		
		request.setAttribute("page", "RoomsList");
		if (roomBO.getRoom(id) != null) {
			int rows = tryParseInt(sRows, -1);
			int columns = tryParseInt(sColumns, -1);
			int status = "on".equals(sChecked) ? 0 : 1;
			Room room = new Room();
			room.setId(id);
			room.setRoomName(roomName);
			room.setRows(rows);
			room.setColumns(columns);
			room.setStatus(status);
			roomBO.updateRoom(room);
			request.setAttribute("message", "Updated susscess!");
			request.getServletContext().getRequestDispatcher("/jsp/Success.jsp").forward(request, response);
		} else {
			request.setAttribute("message", "Room do not exists");
			request.getServletContext().getRequestDispatcher("/jsp/Error.jsp").forward(request, response);
		}
	}

}
