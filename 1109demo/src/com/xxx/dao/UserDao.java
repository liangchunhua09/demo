package com.xxx.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.xxx.entity.User;
import com.xxx.util.DBUtil;


public class UserDao {
	public boolean login(User user){
		Connection conn=null;
		PreparedStatement ps=null;
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement("select * from user where username=? and password=?");
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ResultSet rs = ps.executeQuery();
			user = new User();
			while(rs.next()){
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				System.out.println(user);
				if(user!=null){
					return true;
				}else{
					return false;
				}
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return false;
		
		
		
	}
	

}
