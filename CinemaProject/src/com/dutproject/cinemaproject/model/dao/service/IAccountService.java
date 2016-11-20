package com.dutproject.cinemaproject.model.dao.service;

import java.sql.SQLException;

import com.dutproject.cinemaproject.model.bean.Account;

public interface IAccountService {

	Account getAccount(String username, String password) throws SQLException;

}
