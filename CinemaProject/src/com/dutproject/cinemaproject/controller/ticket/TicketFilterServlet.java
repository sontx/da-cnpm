package com.dutproject.cinemaproject.controller.ticket;

import com.dutproject.cinemaproject.controller.FilterServlet;
import com.dutproject.cinemaproject.model.bean.Account;

public abstract class TicketFilterServlet extends FilterServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected int getServletPermission() {
		return Account.TICKET_MANAGER;
	}
}