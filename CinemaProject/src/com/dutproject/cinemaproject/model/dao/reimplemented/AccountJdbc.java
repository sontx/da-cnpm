package com.dutproject.cinemaproject.model.dao.reimplemented;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.dutproject.cinemaproject.model.bean.Account;
import com.dutproject.cinemaproject.model.dao.service.IAccountService;

public class AccountJdbc extends JdbcService implements IAccountService {

	@Override
	public Account getAccount(String username, String password) throws SQLException {
		CallableStatement callable = null;
		try {
			callable = connection.prepareCall("{call account_getAccount(?,?)}");
			callable.setString(1, username);
			callable.setString(2, password);
			ResultSet rs = callable.executeQuery();
			Account account = null;
			if (rs.next()) {
				account = new Account();
				account.setId(rs.getInt("accountId"));
				account.setUsername(username);
				account.setPermission(rs.getInt("permission"));
			}
			rs.close();
			return account;
		} finally {
			if (callable != null) {
				try {
					callable.close();
				} catch (SQLException e) {
				}
			}
		}
	}

}
