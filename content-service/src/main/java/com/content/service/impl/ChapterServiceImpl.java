package com.content.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.content.dto.request.ChapterDto;
import com.content.model.Chapter;
import com.content.repository.ChapterRepository;
import com.content.service.ChapterService;

@Service
public class ChapterServiceImpl implements ChapterService {

	private ChapterRepository chapterRepo;

	@Autowired
	public ChapterServiceImpl(ChapterRepository chapterRepo) {
		this.chapterRepo = chapterRepo;
	}

	@Override
	public void saveChapter(ChapterDto chapterDto) {
		Chapter chapter = Chapter.builder().title(chapterDto.getTitle()).unitId(chapterDto.getUnitId()).build();

		chapterRepo.save(chapter);
	}

}
