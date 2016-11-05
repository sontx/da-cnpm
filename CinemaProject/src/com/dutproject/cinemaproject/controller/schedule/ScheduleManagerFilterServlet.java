package com.dutproject.cinemaproject.controller.schedule;

import com.dutproject.cinemaproject.controller.FilterServlet;
import com.dutproject.cinemaproject.model.bean.Account;

public abstract class ScheduleManagerFilterServlet extends FilterServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected int getServletPermission() {
		return Account.SCHEDULE_MANAGER;
	}

}
