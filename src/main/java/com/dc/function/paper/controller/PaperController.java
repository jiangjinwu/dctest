package com.dc.function.paper.controller;

import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dc.function.paper.dao.PaperRepository;
import com.dc.function.paper.model.Paper;
import com.dc.function.paper.model.Question;
import com.dc.function.paper.service.PaperService;

@Controller
/*@RequestMapping("paper/")*/
public class PaperController {

	/*@Autowired
	PaperService paperService;
*/
	@Autowired
	PaperRepository paperRepository;
	
	@Autowired
	PaperService paperService;
	
	@RequestMapping("index.html")
	public String index() {
	/* Paper 	 paper  = paperService.getPaper();*/
		return "index";
	}
	
	@RequestMapping("list")
	public String list(Model model) {
	 
		PageRequest pageRequest = new PageRequest(0, 10);
		List<Paper> paperList = paperService.getPageList(pageRequest);
		model.addAttribute("paperList", paperList);
		return "paper/list";
	}
	
	@RequestMapping("createPage.html")
	public String createPage() {
	 
		return "paper/createPage";
	}
	
	@RequestMapping("save.html")
	public String save(Paper paper) {
		
		paper.setPaperUid("1111");
		
		paper.setPaperCtime(Calendar.getInstance().getTime().getTime());
	/*  paperService.savePaper(paper);*/
		
		paperRepository.save(paper);
		return "index";
	}
	
	
	
	@RequestMapping("addQuestionAndOptions.json")
	@ResponseBody
	public Question addQuestionAndOptions( Question question,HttpServletRequest request) {
		
   String questionName =		request.getParameter("question.questionName");
		//,@RequestBody ArrayList<Option> options
		//@RequestBody  Question question
		//question.setQuestionId(UUID.randomUUID().toString());
	  //paperService.saveQuestionAndOptioins(question, options);
		return question;
	}

}
