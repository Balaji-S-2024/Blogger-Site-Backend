package com.example.blogger.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.blogger.models.PostModel;
import com.example.blogger.repository.PostRepo;

@Service
public class PostService {

	@Autowired
	PostRepo postRepo;
	
	public PostModel addPost(PostModel post) {
		return postRepo.save(post);
		
	}

	public PostModel addPost(PostModel post, MultipartFile image) throws IOException {
		post.setImageName(image.getOriginalFilename());
		post.setImageType(image.getContentType());
		post.setPostImage(image.getBytes());
		System.out.println(post.getPostTags());
		return postRepo.save(post);
		
	}

	public List<PostModel> getAllPosts() {
		return postRepo.findAll();
	}
	
	public List<PostModel> getPostById(Integer id) {
		return postRepo.getPostModelById(id);
	}

}
