package com.dutproject.cinemaproject.model.dao;

import java.sql.SQLException;

import com.dutproject.cinemaproject.model.bean.Account;
import com.dutproject.cinemaproject.model.dao.reimplemented.AccountJdbc;
import com.dutproject.cinemaproject.model.dao.service.IAccountService;

public class AccountDAO {
	private IAccountService underlyingService = new AccountJdbc();
	
	public int isValidAccount(Account account) throws SQLException {
		if (account == null)
			return Account.NO_PERMISSION;
		account = underlyingService.getAccount(account.getUsername(), account.getPassword());
		return account == null ? Account.NO_PERMISSION : account.getPermission();
	}
}
