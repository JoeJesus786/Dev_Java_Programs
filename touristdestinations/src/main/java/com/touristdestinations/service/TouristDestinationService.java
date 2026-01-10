package com.touristdestinations.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.touristdestinations.model.TouristDestinationModel;
import com.touristdestinations.repository.TouristDestinationRepository;

@Service
public class TouristDestinationService {

private TouristDestinationRepository touristDestinationRepo;
	
	TouristDestinationService(TouristDestinationRepository repo){
		touristDestinationRepo = repo;
	}

	public TouristDestinationModel saveTouristDestination(TouristDestinationModel touristDestination) {
		return touristDestinationRepo.save(touristDestination);
	}

	public List<TouristDestinationModel> getAllTouristDestination() {
		return touristDestinationRepo.findAll();
	}

	public Optional<TouristDestinationModel> getTouristDestination(Long destinationId) {
		return touristDestinationRepo.findById(destinationId);
	}

	public void deleteTouristDestination(Long destinationId) {
		Optional<TouristDestinationModel> t = touristDestinationRepo.findById(destinationId);
		if(t.isPresent()) {
			touristDestinationRepo.deleteById(destinationId);	
		} 
	}

}
