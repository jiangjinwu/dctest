package com.dc.function.paper.dao;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.dc.function.paper.model.Question;

public interface BaseRepository  extends PagingAndSortingRepository<Question, Long> {

	
	@Cacheable
	List<Question>	findByPaperId(Long paperId);
}
