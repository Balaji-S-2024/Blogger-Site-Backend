package com.example.blogger.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.blogger.models.UserModel;
import com.example.blogger.repository.UserRepo;
import com.example.blogger.service.UserService;

import jakarta.servlet.http.HttpServletRequest;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/")
	public String greet(HttpServletRequest request) {
		System.out.println("Client IP: " + request.getRemoteAddr());
		return ("Hello World!");
	}

	@PostMapping("/add")
	public ResponseEntity<UserModel> addUser(@RequestBody UserModel user) {
		
		System.out.println(user);
		
		ResponseEntity<UserModel> serivceResponse = userService.addUser(user);
		
		try {
			serivceResponse = userService.addUser(user);			
		}
		catch(Exception e) {
			return serivceResponse;
		}
		return serivceResponse;
	}
	
	@GetMapping("/allUsers")
	public List<UserModel> getAllUsers(){
		
		return userService.getAllUsers();
	}
	
	@GetMapping("/{id}")
	public UserModel getUser(@PathVariable Integer id) {
		return userService.getUser(id);
	}
	
	@DeleteMapping("/{id}")
	public String deleteUser(@PathVariable Integer id) {
		System.out.println("=================================================\n\ndelete\n\n\n");
		return userService.deleteUser(id);
	}
	
	@PutMapping("/{id}")
	public UserModel updateUser(@PathVariable Integer id, @RequestBody UserModel userModel) {
		return userService.updateUser(id, userModel);
	}
	
	@PostMapping("/login")
	public ResponseEntity<UserModel> userLogin(@RequestBody UserModel user) {
		System.out.println("coming inside login controller!");
		String clientPassword = user.getPassword();
		String clientUserName = user.getEmail().split("@")[0];
		System.out.println(clientUserName);
		userService.getAllUsers().stream().forEach(u -> System.out.println(u.getUserName()));
		UserModel us = userService.getAllUsers().stream().filter(u -> clientUserName.equals(u.getUserName())).findFirst().orElse(null);        
		String dbPassword = userService.getUser(us.getId()).getPassword();
		System.out.println(" Password Exist " + dbPassword);
		if(clientPassword.equals(dbPassword)) {
			UserModel userClient = userService.getUser(us.getId());
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(userClient);
		}else {			
			return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(new UserModel());
		}
	}
	
	
}
