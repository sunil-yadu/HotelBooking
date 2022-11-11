package com.yash.shoppingmart.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.shoppingmart.dao.ProductDao;
import com.yash.shoppingmart.entities.Product;
import com.yash.shoppingmart.models.ProductModel;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	ProductDao productDao;
	

	@Override
	public List<ProductModel> findAll() {
		List<Product> product=(List<Product>)productDao.getproduct();
		List<ProductModel> productModel=new ArrayList<ProductModel>();
		
		for(Product prod:product) {
			ProductModel prodModel=new ProductModel();
			prodModel.setId(prod.getId());
			prodModel.setName(prod.getName());
			prodModel.setPrice(prod.getPrice());
			productModel.add(prodModel);
			
			
		}
		return productModel;
	
	}

	@Override
	public Product saveProduct(ProductModel productModel) {
		
		Product product=new Product();
	    product.setId(productModel.getId());
	    product.setName(productModel.getName());
	    product.setPrice(productModel.getPrice());
		productDao.saveProduct(product);
		return null;
	}

}
