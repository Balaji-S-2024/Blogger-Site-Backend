package com.example.blogger.models;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
public class PostModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "post_title")
	private String postTitle;
	
	@Column(name = "post_contnet")
	private String postContent;
	
	
//	@Column(name = "posted_by")
//	private String postedBy;
	
	@Column(name = "post_tags")
	private String postTags;
	

//	@Column(name = "created_by")
//	private Date createdAt;
	
//	@Column(name = "liked_by", columnDefinition = "text[]")
//	private List<String> likedBy;
	
//	@Column(name = "commented_by", columnDefinition = "text[]")
//	private List<String> commentedBy;

	@Column(name = "image_type")
	private String imageType;
	
	@Column(name = "image_name")
	private String imageName;
	
	@Lob
	@Column(name = "post_image", columnDefinition = "LONGBLOB")
	private byte[] postImage;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPostTitle() {
		return postTitle;
	}

	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}

	public String getPostContent() {
		return postContent;
	}

	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}

	public byte[] getPostImage() {
		return postImage;
	}

	public void setPostImage(byte[] postImage) {
		this.postImage = postImage;
	}

//	public String getPostedBy() {
//		return postedBy;
//	}

//	public void setPostedBy(String postedBy) {
//		this.postedBy = postedBy;
//	}
	
	public String getPostTags() {
		return postTags;
	}
	
	public void setPostTags(String tags) {
		this.postTags = tags;
	}

//	public Date getCreatedAt() {
//		return createdAt;
//	}

//	public void setCreatedAt(Date createdAt) {
//		this.createdAt = createdAt;
//	}

//	public List<String> getLikedBy() {
//		return likedBy;
//	}

//	public void setLikedBy(List<String> likedBy) {
//		this.likedBy = likedBy;
//	}

//	public List<String> getCommentedBy() {
//		return commentedBy;
//	}

//	public void setCommentedBy(List<String> commentedBy) {
//		this.commentedBy = commentedBy;
//	}
	
	
	public PostModel() {
		
	}
	
//	public PostModel(Integer id, String blogTitle, String blogContent, String blogImage, String postedBy, String tags, Date createdAt, List<String> likedBy, List<String> commentedBy) {
//		this.id = id;
//		this.blogTitle = blogTitle;
//		this.blogContent = blogContent;
//		this.blogImage = blogImage;
//		this.postedBy = postedBy;
//		this.tags = tags;
//		this.createdAt = createdAt;
//		this.likedBy = likedBy;
//		this.commentedBy = commentedBy;
//	}
	
	public PostModel(Integer id, String postTitle, String postContent, byte[] postImage, String postTags) {
		super();
		this.id = id;
		this.postTitle = postTitle;
		this.postContent = postContent;
		this.postImage = postImage;
		this.postTags = postTags;
	}

	public String getImageType() {
		return imageType;
	}

	public void setImageType(String imageType) {
		this.imageType = imageType;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
}
