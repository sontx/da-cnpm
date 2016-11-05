package com.dutproject.cinemaproject.controller.room;

import com.dutproject.cinemaproject.controller.FilterServlet;
import com.dutproject.cinemaproject.model.bean.Account;

public abstract class RoomFilterServlet extends FilterServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected int getServletPermission() {
		return Account.ROOM_MANAGER;
	}
}
