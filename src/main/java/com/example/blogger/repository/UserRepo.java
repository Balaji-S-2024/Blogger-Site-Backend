package com.example.blogger.repository;

import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.blogger.models.UserModel;

@Repository
public interface UserRepo extends JpaRepository<UserModel,Integer> {
	
}
