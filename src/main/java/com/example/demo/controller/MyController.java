package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Course;
import com.example.demo.services.CourseService;

//used for making RESTful web services ..this annotation allows the class to handle the requests made my clients
@RestController  
public class MyController {
	
	@GetMapping("/first")
	public String first() {
		return "Welcome to 1st springboot app";
	}
	
	//for automatic dependency injection
	@Autowired  
	private CourseService courseService;
	//courseService chai interface ho
	
	
	
	//Get the Courses
	// GetMapping used to handle GET type of request methods
	@GetMapping("/courses")     
	public List<Course> getCourses(){
		return this.courseService.getCourses();
		
		//service ma gayera course ko list magxa  
	}
	
	
	//SINGLE COURSE GET
	@GetMapping("/courses/{courseId}")
	public Course getCourse(@PathVariable String courseId) {
		return this.courseService.getCourse(Long.parseLong(courseId));
	}
	
	//COURSE ADD
	//@PostMapping annotation maps HTTP POST requests onto specific handler methods.
	@PostMapping("/courses")    
	public Course addCourse(@RequestBody Course course) {
		return this.courseService.addCourse(course);
	}
	
	
	//UPDATE COURSE USING PUT REQUEST
	@PutMapping("/courses")
	public Course updateCourse(@RequestBody Course course) {
		return this.courseService.updateCourse(course);
	}
	
	
	//DELETE COURSE USING DELETE METHOD
	@DeleteMapping("/courses/{courseId}")
	public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseId){
		try {
			this.courseService.deleteCourse(Long.parseLong(courseId));
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
