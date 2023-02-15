package com.content.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.content.dto.aggregation.ChapterAggregationDto;
import com.content.dto.request.ChapterDto;
import com.content.service.ChapterService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/chapter")
public class ChapterController {
	
	private ChapterService chapterService;
	
	@Autowired
	public ChapterController(ChapterService chapterService) {
		this.chapterService = chapterService;
	}
	
	@PostMapping("addChapter")
	public void postChapter(@RequestBody ChapterDto chapterDto) {
		chapterService.saveChapter(chapterDto);
	}
	
	@GetMapping("{courseId}/{unitId}")
	public List<ChapterAggregationDto> getAllChaptersByUnitId(@PathVariable String unitId){
		return null;
	}
}
