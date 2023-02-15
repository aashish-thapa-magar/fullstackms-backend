package com.content.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;

import com.content.config.CustomAggregationOperation;
import com.content.dto.aggregation.CourseAggregationDto;
import com.content.dto.request.CourseDto;
import com.content.dto.response.CourseResponseDto;
import com.content.model.Course;
import com.content.repository.CourseRepository;
import com.content.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService {

	private CourseRepository courseRepo;
	private MongoTemplate mongoTemplate;

	@Autowired
	public CourseServiceImpl(CourseRepository courseRepo, MongoTemplate mongoTemplate) {
		this.courseRepo = courseRepo;
		this.mongoTemplate = mongoTemplate;
	}

	@Override
	public void saveCourse(CourseDto courseDto) {
		Course course = Course.builder().title(courseDto.getTitle()).description(courseDto.getDescription())
				.prerequisite(courseDto.getPrerequisite()).build();

		courseRepo.save(course);
	}

	@Override
	public List<CourseResponseDto> findAllCourses() {
		return courseRepo.findAll().stream().map(this::mapCourseDto).toList();
	}

	public CourseResponseDto mapCourseDto(Course course) {
		return CourseResponseDto.builder().id(course.getId()).title(course.getTitle())
				.description(course.getDescription()).prerequisite(course.getPrerequisite()).build();
	}

	@Override
	public List<CourseAggregationDto> findCourseContentsByCourseId(String courseId) {

		String query = "{$lookup: {" + "from: 'Units'," + "as: 'units'," + "let: {course_id: '$_id'}," + "pipeline: ["
				+ "{$match: {$expr: {$eq: ['$courseId', '$$course_id'] } } }" + "{$lookup:{" + "from: 'Chapters',"
				+ "as: 'chapters'," + "let: {unit_id: '$_id'}," + "pipeline: ["
				+ "{$match: {$expr: {$eq: ['$unitId', '$$unit_id'] } } } ] } }" + "] } }";

		Aggregation aggregation = Aggregation.newAggregation(Aggregation.match(Criteria.where("_id").is(courseId)),
				new CustomAggregationOperation(query));

		List<CourseAggregationDto> results = mongoTemplate.aggregate(aggregation, "Courses", CourseAggregationDto.class)
				.getMappedResults();

		return results;
	}

}
