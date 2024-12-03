package com.Blog.entity;

import java.time.LocalDate;

import org.springframework.stereotype.Repository;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;

@Repository
@Entity
public class Post {

	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	 	 private String title;
	     private String subheading;
	     private String content;
	     private String imageUrl; 
	     private String author;
	     private LocalDate publishedDate;
	    
	    @PrePersist
	    protected void onCreate() {
	        if (publishedDate == null) {
	            publishedDate = LocalDate.now();
	        }
	    }

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getSubheading() {
			return subheading;
		}

		public void setSubheading(String subheading) {
			this.subheading = subheading;
		}

		public String getContent() {
			return content;
		}

		public void setContent(String content) {
			this.content = content;
		}

		public String getImageUrl() {
			return imageUrl;
		}

		public void setImageUrl(String imageUrl) {
			this.imageUrl = imageUrl;
		}

		public String getAuthor() {
			return author;
		}

		public void setAuthor(String author) {
			this.author = author;
		}

		public LocalDate getPublishedDate() {
			return publishedDate;
		}

		public void setPublishedDate(LocalDate publishedDate) {
			this.publishedDate = publishedDate;
		}

		public Post(String title, String subheading, String content, String imageUrl, String author,
				LocalDate publishedDate) {
			super();
			this.title = title;
			this.subheading = subheading;
			this.content = content;
			this.imageUrl = imageUrl;
			this.author = author;
			this.publishedDate = publishedDate;
		}

		public Post() {
			super();
			// TODO Auto-generated constructor stub
		}

		@Override
		public String toString() {
			return "Post [id=" + id + ", title=" + title + ", subheading=" + subheading + ", content=" + content
					+ ", imageUrl=" + imageUrl + ", author=" + author + ", publishedDate=" + publishedDate + "]";
		}

}
