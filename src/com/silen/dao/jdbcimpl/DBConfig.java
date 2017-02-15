package com.silen.dao.jdbcimpl;

import java.io.IOException;
import java.util.Properties;

public class DBConfig {
	private static Properties prop = new Properties();
	static {
		try {
			prop.load(DBConfig.class.getClassLoader().getResourceAsStream("config.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static String driverClassName = prop.getProperty("driverClassName");
	public static String url = prop.getProperty("url");
	public static String usn = prop.getProperty("usn");
	public static String pwd = prop.getProperty("pwd");
}
