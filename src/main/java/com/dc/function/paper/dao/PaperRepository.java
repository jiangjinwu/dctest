package com.dc.function.paper.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.dc.function.paper.model.Paper;

@Repository
public interface PaperRepository<T>  extends CrudRepository<Paper, Integer>, PagingAndSortingRepository<Paper, Integer> {

	
	Page<T> findAll(Specification<T> spec, Pageable pageable);  //分页按条件查询  
	  
	List<T> findAll(Specification<T> spec);
}
