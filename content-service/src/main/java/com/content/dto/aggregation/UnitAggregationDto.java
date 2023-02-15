package com.content.dto.aggregation;

import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Builder

public class UnitAggregationDto {
	private String title;
	private List<ChapterAggregationDto> chapters;
}
