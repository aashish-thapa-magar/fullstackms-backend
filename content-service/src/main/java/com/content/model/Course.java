package com.content.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Builder

@Document(collection = "Courses")
public class Course {

	@Id
	private String id;
	private String title;
	private String description;
	private String prerequisite;
}
