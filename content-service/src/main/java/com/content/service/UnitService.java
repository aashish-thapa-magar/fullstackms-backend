package com.content.service;

import java.util.List;

import com.content.dto.aggregation.UnitAggregationDto;
import com.content.dto.request.UnitDto;

public interface UnitService {
	public void saveUnit(UnitDto unitDto);
	public void updateUnit(UnitDto unitDto);
	public List<UnitAggregationDto> findAllUnits();
}
