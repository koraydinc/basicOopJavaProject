package main.java.controller;

import main.java.model.Course;
import main.java.service.impl.CourseService;

public class CourseController {
	
	private final CourseService courseService;
	
	public CourseController(CourseService courseService) {
		this.courseService = courseService;
	}

	public void add(Course course) {
		courseService.add(course);
	};
	
	public void delete(Course course) {
		courseService.delete(course);
	};
}
