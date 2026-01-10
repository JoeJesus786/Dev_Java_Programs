package com.example.scb_springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.scb_springboot.dto.ProductRequest;
import com.example.scb_springboot.entity.CategoryEntity;
import com.example.scb_springboot.entity.Product;
import com.example.scb_springboot.repository.CategoryRepository;
import com.example.scb_springboot.repository.ProductRepository;

@Service
public class ProductService {
	
    @Autowired  
    private ProductRepository productRepo;

	@Autowired 
	 private CategoryRepository categoryRepo;

	public Product saveProduct(ProductRequest request) {
		Optional<CategoryEntity> categoryOpt = categoryRepo.findById(request.category_id);
		Product product = new Product();
		if(categoryOpt.isPresent()) {
			product.setName(request.name);
			product.setPrice(request.price);
			product.setCategory(categoryOpt.get());
		}
		return productRepo.save(product);
	}

	public List<Product> getAllProduct() {
		return  productRepo.findAll(Sort.by(Sort.Direction.ASC, "id"));
	}

	public Optional<Product> getProduct(Long productId) {
		return productRepo.findById(productId);
	}

}