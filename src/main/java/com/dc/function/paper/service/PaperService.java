package com.dc.function.paper.service;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;

import com.dc.function.paper.model.Paper;

public interface PaperService {
	public List<Paper> getPageList(PageRequest pageRequest,Specification specification);
	
	public Paper  findOne(Long id);
}