package com.example.scb_springboot.controller;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.scb_springboot.dto.ProductRequest;
import com.example.scb_springboot.entity.Product;
import com.example.scb_springboot.service.ProductService;


@RestController
@RequestMapping("/api/product")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@PostMapping
	public ResponseEntity<Product> saveProduct(@RequestBody ProductRequest product) {
		Product savedRecord = productService.saveProduct(product);
		return new ResponseEntity(savedRecord,HttpStatus.CREATED);	
	}
	
	@GetMapping
	public ResponseEntity<List<Product>> getAll() {
		List<Product> productList = productService.getAllProduct();
		//List<Product> sortedList = productList.stream().sorted(Comparator.comparing(Product::getId)).toList();
		return new ResponseEntity(productList,HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Product> getProduct(@PathVariable("id") Long productId) {
		Optional<Product> fetchedProduct = productService.getProduct(productId);
		if(fetchedProduct == null) {
			return new ResponseEntity(null,HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(fetchedProduct,HttpStatus.OK);
	}
	
}
