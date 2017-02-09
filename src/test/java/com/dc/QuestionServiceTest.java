package com.dc;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
/*
import org.junit.Test;
import org.junit.runner.RunWith;*/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dc.function.paper.dao.BaseRepository;
import com.dc.function.paper.model.Question;
import com.dc.function.paper.model.QuestionOption;

@RunWith(SpringJUnit4ClassRunner.class)  
@ActiveProfiles("test")
@SpringBootTest
@EnableJpaRepositories(basePackages={"com.dc.function.paper.dao"})
public class QuestionServiceTest {

	
	@Autowired
	BaseRepository questionRepository;
	
	@Test
	public void saveQuestion(){
		Question q = new Question();
		
		QuestionOption option1 = new QuestionOption();
		option1.setOptionName("喜");
		
		QuestionOption option2 = new QuestionOption();
		option2.setOptionName("怒");
		
		QuestionOption option3 = new QuestionOption();
		option3.setOptionName("哀");
		
		QuestionOption option4 = new QuestionOption();
		option4.setOptionName("乐");
		ArrayList<QuestionOption> optionList = new ArrayList<>();
		
		optionList.add(option1);
		optionList.add(option2);
		optionList.add(option3);
		optionList.add(option4);
		
		/*q.setQuestionOptions(optionList);*/
		questionRepository.save(q);
	}
}
