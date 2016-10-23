package com.dutproject.cinemaproject.model.dao.reimplemented;

import java.sql.Connection;

import com.dutproject.cinemaproject.model.dao.jdbc.DatabaseManager;

public abstract class JdbcService {
	protected final Connection connection;

	protected JdbcService() {
		connection = DatabaseManager.getInstance().getConnectionProvider().getConnection();
	}
}
