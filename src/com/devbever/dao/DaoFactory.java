package com.devbever.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DaoFactory {
	String url;
	String username;
	String password;
	public DaoFactory(String url, String username, String password) {
		this.url = url;
		this.username = username;
		this.password = password;
	}
	
	public static DaoFactory getInstance() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		DaoFactory instance = new DaoFactory(
				"jdbc:mysql://localhost:3306/tennis?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
				"root",
				""
		);	
		return instance;
	}	
	
	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, username, password);
	}
	
	public MatchDao getMatchDao() {
		return new MatchDaoImp(this);
	}
	
	public PlayerDao getPlayerDao() {
		return new PlayerDaoImp(this);
	}
	
}
