package com.dutproject.cinemaproject.model.dao;

import com.dutproject.cinemaproject.model.bean.Account;
import com.dutproject.cinemaproject.model.bean.Account.Permission;

public class AccountDAO {

	public Account.Permission isValidAccount(Account account) {
		if ("admin1".equals(account.getUsername())) {
			return Permission.FILM_MANAGER;
		} else if ("admin2".equals(account.getUsername())) {
			return Permission.SCHEDULE_MANAGER;
		}
		return Permission.NO_PERMISSION;
	}
}
