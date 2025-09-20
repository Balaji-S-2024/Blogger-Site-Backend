package com.example.blogger.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.blogger.models.PostModel;

@Repository
public interface PostRepo extends JpaRepository<PostModel, Integer>{
	
	public List<PostModel> getPostModelById(Integer id);

}
