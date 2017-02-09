package com.dc.function.paper.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.dc.function.paper.model.Paper;
/*
@NoRepositoryBean
@Repository*/
public interface PaperRepository  extends PagingAndSortingRepository<Paper, Long> {

	
	Page<Paper> findAll(Specification<Paper> spec, Pageable pageable);  //分页按条件查询  
	  
	List<Paper> findAll(Specification<Paper> spec);
}
