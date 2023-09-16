package com.salomone.factory;

import java.sql.Connection;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import java.sql.SQLException;
import javax.sql.DataSource;

public class ConnectionFactory {

	public DataSource dataSource;

	public ConnectionFactory() {
		ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
		comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost:33061/hotelalura?useTimezone=true&serverTimezone=UTC");
		comboPooledDataSource.setUser("root");
		comboPooledDataSource.setPassword("130607da");
		

		this.dataSource = comboPooledDataSource;
	}

	public Connection recuperarConexion() {
		try {
			return this.dataSource.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
