package com.product.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.product.entity.Product;
import com.product.util.BaseDao;

public class ProductDao {
	//分页查询所有商品
	public List<Product> findByPage(int pageNum,int pageSize){
		try {
			List<Product> list = new ArrayList<Product>();
			Connection conn = BaseDao.getConnection();
			PreparedStatement ps = conn.prepareStatement("select * from product limit ?,?");
			ps.setInt(1, (pageNum-1)*pageSize);
			ps.setInt(2, pageSize);
			ResultSet rs=ps.executeQuery();
			Product p=null;
			while(rs.next()){
				p=new  Product();
				p.setId(rs.getInt(1));
				p.setName(rs.getString(2));
				p.setListimg(rs.getString(3));
				p.setPrice(rs.getInt(4));
				list.add(p);
				System.out.println(p);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
		
	}
	public int findCountPage(){
		try {
			Connection conn = BaseDao.getConnection();
			PreparedStatement ps = conn.prepareStatement("select count(id) from product");
			ResultSet rs=ps.executeQuery();
			int count=0;
			while(rs.next()){
				count=rs.getInt(1);
			}
			return count;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
		
	}
	public Product findProductByName(String name){
		try {
			Connection conn = BaseDao.getConnection();
			PreparedStatement ps = conn.prepareStatement("select * from product where name=?");
			ps.setString(1, name);
			ResultSet rs=ps.executeQuery();
			Product p=null;
			while(rs.next()){
				p=new Product();
				p.setId(rs.getInt(1));
				p.setName(rs.getString(2));
				p.setListimg(rs.getString(3));
				p.setPrice(rs.getInt(4));
				System.out.println(p);
			}
			return p;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
		
	}

}
