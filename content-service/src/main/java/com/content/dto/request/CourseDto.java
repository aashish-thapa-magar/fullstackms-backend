package com.content.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Builder

public class CourseDto {
	private String id;
	private String title;
	private String description;
	private String prerequisite;
}
