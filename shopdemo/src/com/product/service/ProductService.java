package com.product.service;

import java.util.List;

import com.product.dao.ProductDao;
import com.product.entity.Product;

public class ProductService {
	ProductDao pd=new ProductDao();
	public List<Product> findAll(){
		List<Product> list=pd.findAll();
		return list;
		
	}
	public List<Product> findByPage(int pageNum,int pageSize){
		List<Product> list=pd.findByPage(pageNum, pageSize);
		return list;
		
	}
	public int findCountPage(){
		int count=pd.findCountPage();
		return count;
		
	}

}
