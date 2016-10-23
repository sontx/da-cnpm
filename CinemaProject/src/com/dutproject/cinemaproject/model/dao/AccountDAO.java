package com.dutproject.cinemaproject.model.dao;

import com.dutproject.cinemaproject.model.bean.Account;

public class AccountDAO {

	public Account.Permission isValidAccount(Account account) {
		if ("admin1".equals(account.getUsername())) {
			return Account.Permission.FILM_MANAGER;
		}
		return Account.Permission.NO_PERMISSION;
	}
}
