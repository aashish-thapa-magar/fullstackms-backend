package com.content.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.content.dto.request.UnitDto;
import com.content.service.UnitService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/unit")
public class UnitController {
	
	private UnitService unitService;
	
	@Autowired
	public UnitController(UnitService unitService) {
		this.unitService = unitService;
	}
	
	@PostMapping("addUnit")
	public void postUnit(@RequestBody UnitDto unitDto) {
		unitService.saveUnit(unitDto);
	}
	
	@PutMapping("updateUnit")
	public void putUnit(@RequestBody UnitDto unitDto) {
		unitService.updateUnit(unitDto);
	}
}
