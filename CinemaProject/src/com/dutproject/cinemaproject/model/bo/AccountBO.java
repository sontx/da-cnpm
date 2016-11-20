package com.dutproject.cinemaproject.model.bo;

import java.sql.SQLException;

import com.dutproject.cinemaproject.model.bean.Account;
import com.dutproject.cinemaproject.model.dao.AccountDAO;

public class AccountBO {
	private AccountDAO accountDAO = new AccountDAO();
	
	public int isValidAccount(Account account) {
		try {
			return accountDAO.isValidAccount(account);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Account.NO_PERMISSION;
	}
}
