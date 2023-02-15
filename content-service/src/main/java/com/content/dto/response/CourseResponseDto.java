package com.content.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Builder

public class CourseResponseDto {
	
	private String id;
	private String title;
	private String description;
	private String prerequisite;
}
