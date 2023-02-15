package com.content.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.content.dto.aggregation.UnitAggregationDto;
import com.content.dto.request.UnitDto;
import com.content.model.Unit;
import com.content.repository.UnitRepository;
import com.content.service.UnitService;

@Service
public class UnitServiceImpl implements UnitService {

	private UnitRepository unitRepo;

	@Autowired
	public UnitServiceImpl(UnitRepository unitRepo) {
		this.unitRepo = unitRepo;
	}

	@Override
	public void saveUnit(UnitDto unitDto) {
		Unit unit = Unit.builder().title(unitDto.getTitle()).courseId(unitDto.getCourseId()).build();

		unitRepo.save(unit);
	}

	@Override
	public void updateUnit(UnitDto unitDto) {
		Unit unit = Unit.builder().id(unitDto.getId()).title(unitDto.getTitle()).build();

		unitRepo.save(unit);
	}

	public UnitAggregationDto mapUnitDto(Unit unit) {
		return UnitAggregationDto.builder().title(unit.getTitle()).build();
	}

	@Override
	public List<UnitAggregationDto> findAllUnits() {
		return unitRepo.findAll().stream().map(this::mapUnitDto).toList();
	}

}
