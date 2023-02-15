package com.content.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.content.dto.aggregation.CourseAggregationDto;
import com.content.dto.request.CourseDto;
import com.content.dto.response.CourseResponseDto;
import com.content.service.CourseService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/course")
public class CourseController {

	private CourseService courseService;

	@Autowired
	public CourseController(CourseService courseService) {
		this.courseService = courseService;
	}

	@PostMapping("/addCourse")
	public void postCourse(@RequestBody CourseDto courseDto) {
		courseService.saveCourse(courseDto);
	}

	@GetMapping("/getAllCourses")
	public List<CourseResponseDto> getAllCourses() {
		return courseService.findAllCourses();
	}

	@GetMapping("/instructor/courses/{courseId}")
	public List<CourseAggregationDto> getCourseContentByCourseId(@PathVariable String courseId) {
		return courseService.findCourseContentsByCourseId(courseId);
	}
}
