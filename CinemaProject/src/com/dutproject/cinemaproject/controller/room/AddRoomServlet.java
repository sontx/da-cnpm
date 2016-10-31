package com.dutproject.cinemaproject.controller.room;





import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dutproject.cinemaproject.model.bean.Room;
import com.dutproject.cinemaproject.model.bo.RoomBO;





/**
 * Servlet implementation class AddRoomServlet
 */
@WebServlet("/AddRoomServlet")
public class AddRoomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddRoomServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		String action = request.getParameter("action");
		String maPhong = request.getParameter("maphong");
		String tenPhong = request.getParameter("tenphong");
		String soHang = request.getParameter("sohang");
		String soCot = request.getParameter("socot");
	
		
		RoomBO roomBO = new RoomBO();
		
		Room room = null;
		
		if (action == null) {
			RequestDispatcher rd = request.getRequestDispatcher("/room/add-room.jsp");
			rd.forward(request, response);
		} else {
			if (maPhong != null && tenPhong != null && soHang != null && soCot != null) {
				
				

		
			
			room = new Room();
			roomBO.addRoom(room);
			response.sendRedirect(request.getContextPath() + "/room/list-room");
		}
		}
	}
}


