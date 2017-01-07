package com.dc.function.paper.service;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.dc.function.paper.dao.PaperRepository;
import com.dc.function.paper.model.Paper;

@Service
public class PaperService {

	/*List getPaperList();
	Paper getPaper();
	
	int savePaper(Paper paper);
	
	int saveQuestionAndOptioins(Question question,ArrayList<Option> options);*/
	
	@Autowired
	PaperRepository<Paper> paperRepository;
	
	
	public List<Paper> getPageList(PageRequest pageRequest){
		Page<Paper> result= 	paperRepository.findAll(new Specification<Paper> () {  
			@Override
			   public Predicate toPredicate(Root<Paper> root,  
			    CriteriaQuery<?> query, CriteriaBuilder cb) {  
			    Path<String> namePath = root.get("paperName");
			   // Path<String> nicknamePath = root.get("nickname");  
			    query.where(cb.like(namePath, "%111%")); //这里可以设置任意条查询条件  
			     
			    return null;  
			   }
			  }, pageRequest);
		return result.getContent();
	}
	
}