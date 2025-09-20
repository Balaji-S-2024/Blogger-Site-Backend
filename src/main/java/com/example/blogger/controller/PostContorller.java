package com.example.blogger.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.blogger.models.PostModel;
import com.example.blogger.models.UserModel;
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
		    @RequestParam("postTags") String tags,
		    @RequestParam("postedBy") String postedBy) {
		System.out.println("Coming PostController");
		PostModel ref = new PostModel();
		System.out.println("tags - " + tags);
		ref.setPostTitle(title);
		ref.setPostContent(content);
		ref.setPostTags(tags);
		UserModel u = new UserModel();
		u.setId(Integer.valueOf(postedBy));
		ref.setPostedBy(u);
		System.out.println(ref.getPostTags());
		try {
			ref = postService.addPost(ref, image);			
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return ref;
	}
	
	@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true")
	@GetMapping("/getAllPosts")
	public List<PostModel> getAllPosts() {
		System.out.println("Fontend requesting");
		List<PostModel> posts = postService.getAllPosts();
		return posts;
	}
	
	@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true")
	@GetMapping("/getPostById/{postedBy}")
	public List<PostModel> getAllPostByUser(@PathVariable Integer postedBy) {
		System.out.println("Fontend requesting");
		List<PostModel> posts = postService.getPostById(postedBy);
		System.out.println("post printing - ");
		System.out.println(posts);
		return posts;
	}

}
