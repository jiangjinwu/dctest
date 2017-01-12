package com.dc.function.paper.controller;

import java.util.Calendar;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dc.function.paper.dao.PaperRepository;
import com.dc.function.paper.model.Paper;
import com.dc.function.paper.model.Question;
import com.dc.function.paper.service.PaperService;

@Controller()
/*@RequestMapping("paper/")*/
public class PaperController {

 
	@Autowired
	PaperRepository paperRepository;
	
	@Autowired
	PaperService paperService;
	
	
	@InitBinder("question")  
	public void initBinderFormQuestion(WebDataBinder binder) {    
        binder.setFieldDefaultPrefix("question.");    
    } 
	@InitBinder("explain")  
	public void initBinderFormExplain(WebDataBinder binder) {    
        binder.setFieldDefaultPrefix("question.explain");    
    } 
	
	
	@RequestMapping("index.html")
	public String index() {
	/* Paper 	 paper  = paperService.getPaper();*/
		return "index";
	}
	
	@RequestMapping("list")
	public String list(Model model) {
	 
		PageRequest pageRequest = new PageRequest(0, 10);
		
		Specification specification = new Specification<Paper> () {  
			@Override
			   public Predicate toPredicate(Root<Paper> root,  
			    CriteriaQuery<?> query, CriteriaBuilder cb) {  
			    Path<String> namePath = root.get("paperName");
			   
			   /* query.where(cb.like(namePath, "%111%"));*/ //这里可以设置任意条查询条件  
			     
			    return null;  
			   }
			  };
		
		List<Paper> paperList = paperService.getPageList(pageRequest,specification);
		model.addAttribute("paperList", paperList);
		return "paper/list";
	}
	
	@RequestMapping("createPaper.html")
	public String createPage() {
	 
		return "paper/createPaper";
	}
	
	@RequestMapping("editPaper.html")
	public String editPaper(Integer paperId,Model model) {
		Paper paper = paperService.findOne(paperId);
		model.addAttribute("paper", paper);
		return "paper/editPaper";
	}
	
	
	@RequestMapping("save.html")
	public String save(Paper paper) {
		
		paper.setPaperUid("1111");
		
		paper.setPaperCtime(Calendar.getInstance().getTime().getTime());
	
		
		paperRepository.save(paper);
		return "paper/list";
	}
	
	@RequestMapping("editQuOp.html")
	public String editQuOp(){
		
		return "paper/editQuOp";
	}
	
	@RequestMapping("addQuestionAndOptions.json")
	@ResponseBody
	//public void addQuestionAndOptions(/* @RequestBody Question question*/ @RequestBody List<Option> options) {
		
		public void addQuestionAndOptions(String options) {
		int i=0;
		
		//,@RequestBody ArrayList<Option> options
		//@RequestBody  Question question
		//question.setQuestionId(UUID.randomUUID().toString());
	  //paperService.saveQuestionAndOptioins(question, options);
		//return questions;
	}
	
	@RequestMapping("addQuestionAndOptions2.html")
	@ResponseBody
	//public void addQuestionAndOptions(/* @RequestBody Question question*/ @RequestBody List<Option> options) {
		
		public void addQuestionAndOptions2(String options) {
		int i=0;
		
		
	}
	
	@RequestMapping("addQuestionAndOptions3.json")
	@ResponseBody
		public void addQuestionAndOptions3(@RequestBody Question question) {
		int i=0;
		i++;
		
	}


}
