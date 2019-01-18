package com.cg.mms.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.cg.mms.exception.MobileException;

public class Jdbcutility {

	private static Connection connection = null;

	public static Connection getConnection() throws MobileException {

		File file = null;
		FileInputStream inputStream = null;

		file = new File("resources/jdbc.properties");
		try {
			inputStream = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			throw new MobileException("file not found");
		}

		Properties properties = new Properties();
		try {
			properties.load(inputStream);

			String driver = properties.getProperty("db.driver");
			String url = properties.getProperty("db.url");
			String username = properties.getProperty("db.username");
			String password = properties.getProperty("db.password");

			Class.forName(driver);
			connection = DriverManager.getConnection(url, "system" , "corp123");

		} catch (IOException e) {
			throw new MobileException("unable to load the file");
		} catch (ClassNotFoundException e) {
			throw new MobileException("class not loaded..");
		} catch (SQLException e) {
			throw new MobileException("not connected..");
		}

		return connection;
	}
}


