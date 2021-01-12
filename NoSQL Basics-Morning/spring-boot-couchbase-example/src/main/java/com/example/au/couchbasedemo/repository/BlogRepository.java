package com.example.au.couchbasedemo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.au.couchbasedemo.model.Blogs;

public interface BlogRepository extends CrudRepository<Blogs, String> {
	
	List<Blogs> findByAuthor(String author);
	List<Blogs> findByTags(List<String> tags);
	List deleteBytopicAndAuthor(String title, String author);
	   
}