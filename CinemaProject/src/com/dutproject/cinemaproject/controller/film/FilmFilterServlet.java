package com.dutproject.cinemaproject.controller.film;

import com.dutproject.cinemaproject.controller.FilterServlet;
import com.dutproject.cinemaproject.model.bean.Account;

public abstract class FilmFilterServlet extends FilterServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected int getServletPermission() {
		return Account.FILM_MANAGER;
	}
}
