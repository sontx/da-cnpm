package com.dutproject.cinemaproject.controller.admin;

import com.dutproject.cinemaproject.controller.FilterServlet;
import com.dutproject.cinemaproject.model.bean.Account;

public abstract class AdminFilterServlet extends FilterServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected int getServletPermission() {
		return Account.ACCOUNT_MANAGER;
	}
}
