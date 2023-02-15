package com.content.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Builder

@Document(collection="Units")
public class Unit {
	
	@Id
	private String id;
	private String title;
	@DocumentReference
	private Course courseId;
}
