package com.example.scb_springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.scb_springboot.entity.SportEntity;

public interface SportRepository extends JpaRepository<SportEntity, Long> {}