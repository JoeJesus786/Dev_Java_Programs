package com.example.scb_springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.scb_springboot.entity.CategoryEntity;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {



}
