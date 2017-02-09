package com.dc.function.buy.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dc.base.util.TimeUtil;
import com.dc.function.buy.dao.CartRepository;
import com.dc.function.buy.dao.OrderPaperRepository;
import com.dc.function.buy.model.Cart;
import com.dc.function.buy.model.OrderPaper;
import com.dc.function.user.model.AccountInfo;
/**
 * 
 * @author jiangjinwu
 *  增加組合套裝
 *  购物车
 *  
 */
@Controller
@RequestMapping("buy/")
public class BuyController {

	
	@Autowired
	OrderPaperRepository orderPaperRepository;
	
	@Autowired
	CartRepository cartRepository;
	
	@RequestMapping("buyView")
	public String buyView(Long paperId,Model model){
		
		model.addAttribute("paperId", paperId);
		
		return "buy/buyView";
	} 
	
	public String postOrder(OrderPaper orderPaper){
		orderPaper.setExpireDate(TimeUtil.getDateAfter(orderPaper.getPaper().getExpireDayCount()));
		orderPaperRepository.save(orderPaper);
		return "buy/pay";
	}
	
	@RequestMapping("add2cart.json")
	@ResponseBody
	public String add2Cart(@RequestBody Cart cart,HttpServletRequest request){
		AccountInfo accountInfo= (AccountInfo)request.getSession().getAttribute("Account");
		cart.setAccountId(accountInfo.getAccountId());
		
		Cart cartInfo =cartRepository.getCartByAccountIdAndPaperId(cart.getCartId(),cart.getAccountId());
		
		if(cartInfo!=null){
			cartInfo.setBuyNum(cartInfo.getBuyNum()+cart.getBuyNum());
		}
		cartRepository.save(cartInfo);
		return "ok";
	} 
}
