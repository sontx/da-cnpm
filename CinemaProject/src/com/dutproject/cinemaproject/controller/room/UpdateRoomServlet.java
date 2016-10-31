package com.dutproject.cinemaproject.controller.room;





import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dutproject.cinemaproject.model.bean.Room;
import com.dutproject.cinemaproject.model.bo.RoomBO;




/**
 * Servlet implementation class SuaDotDanhGiaServlet
 */
public class UpdateRoomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateRoomServlet() {
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
		
		//GetParameter
		String action = request.getParameter("action");
		String tenPhong = request.getParameter("tenphong");
		String soHang = request.getParameter("sohang");
		String soCot = request.getParameter("socot");
	
		
	
		
		//BO
		RoomBO roomBO = new RoomBO();
		
		//Object
		Room room = null;
		
	
		
		//kiem tra action
		if (action == null) {
			request.setAttribute("room", room);
			
			RequestDispatcher rd = request.getRequestDispatcher("/room/update-room.jsp");
			rd.forward(request, response);
		} else {
			if (tenPhong != null && soHang != null && soCot != null) {
				
				if (room != null) {
					
					room.setTenPhong(tenPhong);
				
					
					roomBO.updateRoom(room);	
				}
				
			}
			
			response.sendRedirect(request.getContextPath() + "/room/list-room");
		}
	}

}
