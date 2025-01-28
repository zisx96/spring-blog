package com.Blog.entity;

import java.time.LocalDate;
import java.util.Arrays;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

@Entity
public class Post {

	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private String title;
	    private String subheading;
	    private String description;
	    private String content;
	    
	    @Lob
	    private byte[] image;
	    private String author;
	    private LocalDate publishedDate;
	    
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
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public String getContent() {
			return content;
		}
		public void setContent(String content) {
			this.content = content;
		}
		public byte[] getImage() {
			return image;
		}
		public void setImage(byte[] image) {
			this.image = image;
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
		public Post(String title, String subheading, String description, String content, byte[] image, String author,
				LocalDate publishedDate) {
			super();
			this.title = title;
			this.subheading = subheading;
			this.description = description;
			this.content = content;
			this.image = image;
			this.author = author;
			this.publishedDate = publishedDate;
		}
		public Post() {
			super();
			// TODO Auto-generated constructor stub
		}
		@Override
		public String toString() {
			return "Post [id=" + id + ", title=" + title + ", subheading=" + subheading + ", description=" + description
					+ ", content=" + content + ", image=" + Arrays.toString(image) + ", author=" + author
					+ ", publishedDate=" + publishedDate + "]";
		}

}
