package com.dutproject.cinemaproject.model.dao;

import com.dutproject.cinemaproject.model.bean.Account;

public class AccountDAO {

	public int isValidAccount(Account account) {
		if ("admin1".equals(account.getUsername())) {
			return Account.FILM_MANAGER;
		}
		return Account.NO_PERMISSION;
	}
}
