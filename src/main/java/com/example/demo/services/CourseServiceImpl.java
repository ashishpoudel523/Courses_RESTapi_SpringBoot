package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.demo.entities.Course;

@Service
public class CourseServiceImpl implements CourseService {
	
	List<Course> list;
	
	
	public CourseServiceImpl() {
		list = new ArrayList<>();
		list.add(new Course(123, "Java Basics", "For Java Beginners"));
		list.add(new Course(345, "Docker", "For Advanced Programmers"));
	}
	
	
	@Override
	public List<Course> getCourses(){ 
		//CourseService interface vitra function ko body hudaina,so run time polymorphism or getCourse() ko method overriding yaha vayo, jasle lsit of course return garxa.
		return list;
	}


	@Override
	public Course getCourse(long courseId) {
		Course c = null;
		for(Course course:list) {
			if(course.getId()==courseId) {
				c=course;
				break;
			}
		}
		return c;
	}


	@Override
	public Course addCourse(Course course) {
		list.add(course);
		return course;
	}


	@Override
	public Course updateCourse(Course course) {
		list.forEach(e -> {
			if(e.getId() == course.getId()) {
				e.setTitle(course.getTitle());
				e.setDescription(course.getDescription());
				
			}
		});
		return course;
	}


	@Override
	public void deleteCourse(long parseLong) {
		list = this.list.stream().filter(e->e.getId()!=parseLong).collect(Collectors.toList());
		
	}
		
}
