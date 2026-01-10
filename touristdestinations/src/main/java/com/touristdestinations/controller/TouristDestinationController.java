package com.touristdestinations.controller;

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

import com.touristdestinations.model.TouristDestinationModel;
import com.touristdestinations.service.TouristDestinationService;


@RestController
@RequestMapping("/tourism/platform/v1/destinations")
public class TouristDestinationController {

	@Autowired
	TouristDestinationService touristDestinationService;
	
	@PostMapping
	public ResponseEntity<TouristDestinationModel> saveTouristDestination(@RequestBody TouristDestinationModel touristDestination) {
		TouristDestinationModel savedRecord = touristDestinationService.saveTouristDestination(touristDestination);
		return new ResponseEntity(savedRecord,HttpStatus.CREATED);	
	}
	
	@GetMapping
	public ResponseEntity<List<TouristDestinationModel>> getAll() {
		List<TouristDestinationModel> touristDestinationList = touristDestinationService.getAllTouristDestination();
		List<TouristDestinationModel> sortedList = touristDestinationList.stream().sorted(Comparator.comparing(TouristDestinationModel::getId).reversed()).toList();
		return new ResponseEntity(sortedList,HttpStatus.OK);
	}
	
	@GetMapping("/{destinationId}")
	public ResponseEntity<TouristDestinationModel> getTouristDestination(@PathVariable("destinationId") Long destinationId) {
		Optional<TouristDestinationModel> fetchedTouristDestination = touristDestinationService.getTouristDestination(destinationId);
		if(fetchedTouristDestination == null) {
			return new ResponseEntity(null,HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(fetchedTouristDestination,HttpStatus.OK);
	}
	
	@DeleteMapping("/{destinationId}")
	public ResponseEntity<TouristDestinationModel> deleteTouristDestination(@PathVariable("destinationId") Long destinationId) {
		touristDestinationService.deleteTouristDestination(destinationId);
		return new ResponseEntity(null,HttpStatus.NO_CONTENT);
	}
}
