package com.dc.function.paper.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.dc.function.paper.model.QuestionOption;

public interface OptionRepository  extends PagingAndSortingRepository<QuestionOption, Long> {

}
