package com.content.dto.aggregation;

import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Builder

public class CourseAggregationDto {
	private String title;
	private List<UnitAggregationDto> units;
}
