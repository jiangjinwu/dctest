package com.dc.function.buy.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.dc.function.buy.model.OrderPaper;

public interface OrderPaperRepository extends PagingAndSortingRepository<OrderPaper, Long>{

}
