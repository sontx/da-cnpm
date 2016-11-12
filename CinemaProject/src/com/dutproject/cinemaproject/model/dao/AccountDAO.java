package com.dutproject.cinemaproject.model.dao;

import com.dutproject.cinemaproject.model.bean.Account;

public class AccountDAO {

	public int isValidAccount(Account account) {
		if ("admin1".equals(account.getUsername())) {
			return Account.ACCOUNT_MANAGER;
		} else if ("admin2".equals(account.getUsername())) {
			return Account.SCHEDULE_MANAGER;
		} else if ("admin3".equals(account.getUsername())) {
			return Account.ROOM_MANAGER;
		} else if ("adminfilm".equals(account.getUsername())) {
			return Account.FILM_MANAGER;
		} else if ("adminticket".equals(account.getUsername())) {
			return Account.TICKET_MANAGER;
		}
		return Account.NO_PERMISSION;
	}
}
