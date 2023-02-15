package com.content.service;

import java.util.List;

import com.content.dto.aggregation.CourseAggregationDto;
import com.content.dto.request.CourseDto;
import com.content.dto.response.CourseResponseDto;

public interface CourseService {
	public void saveCourse(CourseDto courseDto);
	public List<CourseResponseDto> findAllCourses();
	public List<CourseAggregationDto> findCourseContentsByCourseId(String courseId);
}
