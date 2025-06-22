package com.example.blogger.service;

import java.net.http.HttpResponse;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.blogger.models.UserModel;
import com.example.blogger.repository.UserRepo;

@Service
public class UserService {
	
	@Autowired
	UserRepo userRepo;
	
	public ResponseEntity<UserModel> addUser(UserModel user) {
		
		UserModel repoResponse = userRepo.save(user);
		System.out.println("coming" + repoResponse);
		
		try {
			repoResponse = userRepo.save(user);			
		}
		catch(DataIntegrityViolationException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(repoResponse);
		}
		return ResponseEntity.status(HttpStatus.OK).body(repoResponse);
	}
	
	public List<UserModel> getAllUsers(){
		
		List<UserModel> users;
		
		try {
			users = userRepo.findAll();
		}
		catch(Exception e) {
			users = null;
		}
		return users;
	}
	
	public UserModel getUser(Integer id) {
		return userRepo.findById(id).map(u -> u).orElse(null);
		
	}

	public String deleteUser(Integer id) {
			userRepo.deleteById(id);
		return "USER DELETED SEUCCESSFULLY!!!";
	}

	public UserModel updateUser(Integer id, UserModel userModel) {
		userModel.setId(id);
		return userRepo.save(userModel);
	}

}
