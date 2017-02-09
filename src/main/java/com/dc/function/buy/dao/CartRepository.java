package com.dc.function.buy.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.dc.function.buy.model.Cart;

public interface CartRepository extends PagingAndSortingRepository<Cart, Long> {

	Cart getCartByAccountIdAndPaperId(Long paperId,Long AccountId);
}
