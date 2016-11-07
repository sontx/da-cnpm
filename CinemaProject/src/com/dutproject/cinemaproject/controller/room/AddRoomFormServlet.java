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

@WebServlet(name = "AddRoomForm", urlPatterns = { "/Room/AddRoomForm" })
public class AddRoomFormServlet extends RoomFilterServlet {
	private static final long serialVersionUID = 1L;
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/jsp/Room/AddRoomForm.jsp").forward(request, response);;
	}

}
