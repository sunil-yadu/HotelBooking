package com.yash.shoppingmart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yash.shoppingmart.dao.ProductDao;
import com.yash.shoppingmart.entities.Product;
import com.yash.shoppingmart.models.ProductModel;
import com.yash.shoppingmart.service.ProductService;


@RestController
@RequestMapping("/os")
public class ProductController {

	@Autowired
	private ProductService productService;

	@PostMapping("/saveProduct")
	public String save(@RequestBody ProductModel productModel) {
		productService.saveProduct(productModel);
		return "saved successfully";
	}

	@GetMapping("/getAllProduct")
	public List<ProductModel> getAllProduct() {
		return productService.findAll();

	}

}

