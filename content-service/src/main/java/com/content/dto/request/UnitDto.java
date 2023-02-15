package com.content.dto.request;

import com.content.model.Course;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Builder

public class UnitDto {
	
	private String id;
	private String title;
	private Course courseId;
}
