package com.example.demo.services;

import java.util.List;

import com.example.demo.entities.Course;

public interface CourseService {
	
	
	//interface vitra abstract method banauni jun chai body hudaina.
	public List<Course> getCourses();
	
	public Course getCourse(long courseId);
	
	public Course addCourse(Course course);

	public Course updateCourse(Course course);

	public void deleteCourse(long parseLong);
}
