package com.yash.shoppingmart.service;

import java.util.List;

import com.yash.shoppingmart.entities.Product;
import com.yash.shoppingmart.models.ProductModel;



public interface ProductService {
	
	List<ProductModel> findAll();

	Product saveProduct(ProductModel productModel);

}
