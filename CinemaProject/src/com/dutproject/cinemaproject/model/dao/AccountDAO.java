package com.dutproject.cinemaproject.model.dao;

import com.dutproject.cinemaproject.model.bean.Account;

public class AccountDAO {

	public int isValidAccount(Account account) {
		if ("admin1".equals(account.getUsername())) {
			return Account.ACCOUNT_MANAGER;
		} else if ("admin2".equals(account.getUsername())) {
			return Account.SCHEDULE_MANAGER;
		}
		return Account.NO_PERMISSION;
	}
}
