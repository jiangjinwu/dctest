package com.dc.function.paper.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.dc.function.paper.dao.BaseRepository;
import com.dc.function.paper.dao.PaperRepository;
import com.dc.function.paper.model.Paper;

@Service
public class PaperServiceImpl implements PaperService {

	/*List getPaperList();
	Paper getPaper();
	
	int savePaper(Paper paper);
	
	int saveQuestionAndOptioins(Question question,ArrayList<Option> options);*/
	
	@Autowired
	PaperRepository paperRepository;
	
	@Autowired
	BaseRepository baseRepository;
	
	
	
	public List<Paper> getPageList(PageRequest pageRequest,Specification specification){
		Page<Paper> result= 	paperRepository.findAll(specification, pageRequest);
		return result.getContent();
	}
	
	public Paper  findOne(Long id){
		 Paper  result= 	paperRepository.findOne(id);
		return result;
	}
	
/*	public Question findPaperQuestionList(){
		baseRepository.fin
	}*/
	
}