package com.dutproject.cinemaproject.model.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SqlServerConnectionProvider implements IConnectionProvider {
	private static final String JDBC_DRIVER = "net.sourceforge.jtds.jdbc.Driver";
	private static final String INSTANCE_NAME = "SQLEXPRESS";
	private Connection connection;

	public SqlServerConnectionProvider(String host, String databaseName, String username, String password)
			throws ClassNotFoundException, SQLException {
		Class.forName(JDBC_DRIVER);
		String url = String.format("jdbc:jtds:sqlserver://%s:1433/%s;instance=%s", host, databaseName, INSTANCE_NAME);
		connection = DriverManager.getConnection(url, username, password);
	}

	@Override
	public Connection getConnection() {
		return connection;
	}

}
