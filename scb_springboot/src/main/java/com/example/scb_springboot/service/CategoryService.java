package com.example.scb_springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.scb_springboot.dto.CategoryRequest;
import com.example.scb_springboot.entity.CategoryEntity;
import com.example.scb_springboot.repository.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepo;
	
	public CategoryEntity saveCategory(CategoryRequest request) {
		CategoryEntity category = new CategoryEntity();
		 category.setName(request.name);		
		 return categoryRepo.save(category);
	}

	public List<CategoryEntity> getAllCategory() {
		return categoryRepo.findAll(Sort.by(Sort.Direction.ASC, "id"));
	}
	
	public Optional<CategoryEntity> getCategory(Long categoryId) {
		return categoryRepo.findById(categoryId);
	}

}