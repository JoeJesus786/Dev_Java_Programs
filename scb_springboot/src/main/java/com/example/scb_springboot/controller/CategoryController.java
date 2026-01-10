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
import com.example.scb_springboot.dto.CategoryRequest;
import com.example.scb_springboot.entity.CategoryEntity;
import com.example.scb_springboot.entity.Product;
import com.example.scb_springboot.entity.TouristDestination;
import com.example.scb_springboot.service.CategoryService;
import com.example.scb_springboot.service.ProductService;
import com.example.scb_springboot.service.TouristDestinationService;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
	
	@Autowired
	CategoryService categoryService;
	
	@PostMapping
	public ResponseEntity<CategoryEntity> saveCategory(@RequestBody CategoryRequest request) {
		CategoryEntity savedRecord = categoryService.saveCategory(request);
		return new ResponseEntity(savedRecord,HttpStatus.CREATED);	
	}
	
	@GetMapping
	public ResponseEntity<List<CategoryEntity>> getAll() {
		List<CategoryEntity> categoryList = categoryService.getAllCategory();
		return new ResponseEntity(categoryList,HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CategoryEntity> getCategory(@PathVariable("id") Long categoryId) {
		Optional<CategoryEntity> fetchedCategory = categoryService.getCategory(categoryId);
		if(fetchedCategory == null) {
			return new ResponseEntity(null,HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(fetchedCategory,HttpStatus.OK);
	}
	
}

