package com.dc.function.buy.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.dc.function.buy.model.OrderInfo;

public interface OrderRepository extends PagingAndSortingRepository<OrderInfo, Long> {

}
