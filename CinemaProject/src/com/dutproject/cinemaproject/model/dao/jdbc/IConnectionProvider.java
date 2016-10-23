package com.dutproject.cinemaproject.model.dao.jdbc;

import java.sql.Connection;

public interface IConnectionProvider {
	Connection getConnection();
}
