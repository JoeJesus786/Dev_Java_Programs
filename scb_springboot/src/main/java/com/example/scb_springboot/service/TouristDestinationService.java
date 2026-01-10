package com.example.scb_springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.scb_springboot.entity.TouristDestination;
import com.example.scb_springboot.repository.TouristDestinationRepository;


@Service
public class TouristDestinationService {
	
	private TouristDestinationRepository touristDestinationRepo;
	
	TouristDestinationService(TouristDestinationRepository repo){
		touristDestinationRepo = repo;
	}

	public TouristDestination saveTouristDestination(TouristDestination touristDestination) {
		return touristDestinationRepo.save(touristDestination);
	}

	public List<TouristDestination> getAllTouristDestination() {
		return touristDestinationRepo.findAll();
	}

	public Optional<TouristDestination> getTouristDestination(Long destinationId) {
		return touristDestinationRepo.findById(destinationId);
	}

	public void deleteTouristDestination(Long destinationId) {
		Optional<TouristDestination> t = touristDestinationRepo.findById(destinationId);
		if(t.isPresent()) {
			touristDestinationRepo.deleteById(destinationId);	
		} 
	}



}
