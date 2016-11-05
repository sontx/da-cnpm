package com.dutproject.cinemaproject.controller.room;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dutproject.cinemaproject.model.bean.AccountProfile;
import com.dutproject.cinemaproject.model.bean.Room;
import com.dutproject.cinemaproject.model.bo.RoomBO;

@WebServlet(name = "DeleteRoomAction", urlPatterns = { "/Room/DeleteRoomAction" })
public class DeleteRoomActionServlet extends RoomFilterServlet {
	private static final long serialVersionUID = 1L;
	private RoomBO roomBO = new RoomBO();

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sId = request.getParameter("id");
		int id = tryParseInt(sId, -1);
		Room room = roomBO.getRoom(id);
		request.setAttribute("page", "RoomsList");
		if (room != null) {
			roomBO.deleteRoom(id);
			request.setAttribute("message", "Removed successful");
			request.getServletContext().getRequestDispatcher("/jsp/Success.jsp").forward(request, response);
		} else {
			request.setAttribute("message", "Room do not exist");
			request.getServletContext().getRequestDispatcher("/jsp/Error.jsp").forward(request, response);
		}
	}

}
