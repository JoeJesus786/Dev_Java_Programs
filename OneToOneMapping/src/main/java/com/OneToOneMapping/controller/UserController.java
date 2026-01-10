package com.OneToOneMapping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.OneToOneMapping.Model.Address;
import com.OneToOneMapping.Model.User;
import com.OneToOneMapping.Repository.AddressRepository;
import com.OneToOneMapping.Repository.UserRepository;
import com.OneToOneMapping.UserDTO.UserDTO;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AddressRepository addressRepository;
	


	@PostMapping
	public User createuser(@RequestBody User user)
	{
		Address address = user.getAddress();
		addressRepository.save(address);
		return userRepository.save(user);
	}

	@GetMapping
	public List<User> getAllUsers()
	{
		return userRepository.findAll();
	}
	
	public ResponseEntity<?> deleteUser(@PathVariable Long id)
	{
		 userRepository.deleteById(id);
		 return ResponseEntity.ok().build();
	}

//	@PostMapping
//	public ResponseEntity<User> createuser(@RequestBody UserDTO userDTO)
//	{
//		Address address = new Address(userDTO.getStreet());
//		addressRepository.save(address);
//		
//		User user = new User(userDTO.getName(), address);
//		userRepository.save(user);
//		
//		return ResponseEntity.ok(user);
//	}
}

