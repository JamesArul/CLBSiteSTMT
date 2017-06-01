package com.jpro.studentsmeetcontrollerrest.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jpro.studentsmeetbackend.dao.BlogDAO;
import com.jpro.studentsmeetbackend.model.Blog;

@RestController
public class BlogController {
	
	private static final Logger log=LoggerFactory.getLogger(BlogController.class);
	
	@Autowired
	private Blog blog;
	
	@Autowired
	private BlogDAO blogDAO;
	
	@PostMapping("/createBlog")
	public ResponseEntity<Blog> createBlog(@RequestBody Blog newblog){
		log.debug("Start of createBlog");
		boolean valid=blogDAO.createBlog(newblog);
		if(valid)
		{
			log.debug("Blog Created");
			newblog.setErrorCode("200");
			newblog.setErrorMsg("Blog Created");
			return new ResponseEntity<Blog>(newblog,HttpStatus.OK);
		}
		else
		{
			log.debug("Error creating blog");
			newblog.setErrorCode("400");
			newblog.setErrorMsg("Blog not Created");
			return new ResponseEntity<Blog>(newblog,HttpStatus.OK);
		}
	}
	
	@PostMapping("/updateBlog")
	public ResponseEntity<Blog> updateBlog(@RequestBody Blog updateBlog)
	{
		log.debug("Start of method updateBlog");
		boolean valid=blogDAO.updateBlog(updateBlog);
		if(valid)
		{
			log.debug("Blog updated");
			updateBlog.setErrorCode("200");
			updateBlog.setErrorMsg("Blog updated");
			return new ResponseEntity<Blog>(updateBlog,HttpStatus.OK);
		}
		else
		{
			log.debug("Error updating blog");
			updateBlog.setErrorCode("400");
			updateBlog.setErrorMsg("Blog not updated");
			return new ResponseEntity<Blog>(updateBlog,HttpStatus.OK);
		}
	}
	
	@GetMapping("/removeBlog/{blogId}")
	public String removeBlog(@PathVariable("blogId") long blogId){
		log.debug("Start of method removeBlog");
		boolean valid=blogDAO.removeBlog(blogId);
		if(valid){
			log.debug("Blog removed");
			return "Success";
		}
		else{
			log.debug("Blog not removed");
			return "Error";
		}
	}

	@GetMapping("/getBlogById/{blogID}")
	public ResponseEntity<Blog> getBlogById(@PathVariable("blogID") long blogID){
		log.debug("Getting blod with blogID:"+blogID);
		blog=blogDAO.getBlogById(blogID);
		if(blog!=null){
			log.debug("blog obtained");
			return new ResponseEntity<Blog>(blog,HttpStatus.OK);
		}
		else{
			log.debug("Blog not obtained");
			return null;
		}
	}
	
	@PostMapping("/getAllBlog")
	public ResponseEntity<List<Blog>> getAllBlog(){
		log.debug("Getting all blogs");
		return new ResponseEntity<List<Blog>>(blogDAO.getAllBlogs(),HttpStatus.OK);
	}

}
