package com.dutproject.cinemaproject.model.bo;

import com.dutproject.cinemaproject.model.bean.Account;
import com.dutproject.cinemaproject.model.dao.AccountDAO;

public class AccountBO {
	private AccountDAO accountDAO = new AccountDAO();
	
	public int isValidAccount(Account account) {
		return accountDAO.isValidAccount(account);
	}
}
