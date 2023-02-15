package com.content.dto.request;

import com.content.model.Unit;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Builder

public class ChapterDto {
	
	private String id;
	private String title;
	private Unit unitId;
}
