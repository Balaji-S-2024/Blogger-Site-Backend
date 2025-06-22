package com.example.blogger.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.blogger.models.PostModel;
import com.example.blogger.service.PostService;

import jakarta.servlet.annotation.MultipartConfig;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("post")
public class PostContorller {
	
	@Autowired
	PostService postService;
	
	@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true")
	@PostMapping("/addPost")
	public PostModel addPost(
			@RequestParam("postTitle") String title,
		    @RequestParam("postContent") String content,
		    @RequestParam("postImage") MultipartFile image,
		    @RequestParam("postTags") String tags ) {
		System.out.println("Coming PostController");
		PostModel ref = new PostModel();
		System.out.println("tags - " + tags);
		ref.setPostTitle(title);
		ref.setPostContent(content);
		ref.setPostTags(tags);
		System.out.println(ref.getPostTags());
		try {
			ref = postService.addPost(ref, image);			
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return ref;
	}
	
	@CrossOrigin(origins = "http://192.168.1.10:5173", allowCredentials = "true")
	@GetMapping("/getAllPosts")
	public List<PostModel> getAllPosts() {
		System.out.println("Fontend requesting");
		List<PostModel> posts = postService.getAllPosts();
		return posts;
	}

}
