package com.product.util;


import java.sql.Connection;
import java.sql.DriverManager;

public class BaseDao {
	//加载数据库驱动-->数据库连接-->执行Sql语句-->返回结果记录集
	static{
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection(){
		try{
			Connection con=DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1:3306/shop?useUnicode=true&characterEncoding=UTF-8","root","root");
			return con;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

}
