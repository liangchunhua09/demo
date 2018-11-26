package com.xxx.util;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author hasee
 *
 */
public class DBUtil {
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static Connection getConnection(){
		String url = "jdbc:mysql://127.0.0.1:3306/user?useUnicode=true&characterEncoding=UTF-8";
		String username="root";
		String password="root";
		try {
			Connection conn = DriverManager.getConnection(url, username, password);
			return conn;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
}
