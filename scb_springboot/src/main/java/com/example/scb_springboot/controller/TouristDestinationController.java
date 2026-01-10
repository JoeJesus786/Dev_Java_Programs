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

import com.example.scb_springboot.entity.Task;
import com.example.scb_springboot.entity.TouristDestination;
import com.example.scb_springboot.service.TaskService;
import com.example.scb_springboot.service.TouristDestinationService;


@RestController
@RequestMapping("/tourism/platform/v1/destinations")
public class TouristDestinationController {
	
	@Autowired
	TouristDestinationService touristDestinationService;
	
	@PostMapping
	public ResponseEntity<TouristDestination> saveTouristDestination(@RequestBody TouristDestination touristDestination) {
		TouristDestination savedRecord = touristDestinationService.saveTouristDestination(touristDestination);
		return new ResponseEntity(savedRecord,HttpStatus.CREATED);	
	}
	
	@GetMapping
	public ResponseEntity<List<TouristDestination>> getAll() {
		List<TouristDestination> touristDestinationList = touristDestinationService.getAllTouristDestination();
		List<TouristDestination> sortedList = touristDestinationList.stream().sorted(Comparator.comparing(TouristDestination::getId).reversed()).toList();
		return new ResponseEntity(sortedList,HttpStatus.OK);
	}
	
	@GetMapping("/{destinationId}")
	public ResponseEntity<TouristDestination> getTouristDestination(@PathVariable("destinationId") Long destinationId) {
		Optional<TouristDestination> fetchedTouristDestination = touristDestinationService.getTouristDestination(destinationId);
		if(fetchedTouristDestination == null) {
			return new ResponseEntity(null,HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(fetchedTouristDestination,HttpStatus.OK);
	}
	
	@DeleteMapping("/{destinationId}")
	public ResponseEntity<TouristDestination> deleteTouristDestination(@PathVariable("destinationId") Long destinationId) {
		touristDestinationService.deleteTouristDestination(destinationId);
		return new ResponseEntity(null,HttpStatus.NO_CONTENT);
	}
	
}
