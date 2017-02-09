package com.dc.function.user.controller;

import java.security.Principal;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

//import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.dc.function.user.dao.AccountRepository;
import com.dc.function.user.dao.UserRepository;
import com.dc.function.user.model.AccountInfo;
import com.dc.function.user.model.UserInfo;
import com.dc.function.user.service.UserService;
import com.dc.function.web.SessionHolder;

@Controller
public class UserController {

	@Autowired
	AccountRepository accountRepository;
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserService userService;
	
	@RequestMapping("login.html")
	public String loginPage(){
		
		
		return "user/login";
	}
	
	
	@RequestMapping("doLogin.html")
	public String login(AccountInfo account,HttpServletRequest request) throws ServletException{
		
	AccountInfo accountInfo =	accountRepository.getAccountByAccountName( account.getAccountName());
		if(accountInfo !=null && accountInfo.getPassWord().equals(account.getPassWord())){
			
			
			userService.signUp(accountInfo.getUserInfo());
			
			request.login(account.getAccountName(), account.getPassWord());
			request.getSession().setAttribute("Account", accountInfo);
			return "redirect:home.html";
		}else{
			return "user/login";
		}
		
	}
	

	@RequestMapping("regist.html")
	public String registPage(AccountInfo account,HttpServletRequest request){
	
//		Md5PasswordEncoder encode = new Md5PasswordEncoder();
//		encode.encodePassword(arg0, arg1);
		
		
		Date registDate = new Date();
		UserInfo userInfo = new UserInfo();
		userInfo.setCreateDate(registDate );
		userRepository.save(userInfo);
		
	    account.setCreateDate(registDate);
	    account.setUserInfo(userInfo);
		accountRepository.save(account);
		
		SessionHolder.setAccount(account);
		
		
		
		return "user/login";
	}
	
	@RequestMapping("home.html")
	public String home(Principal principal,Model mode){
		
		String accountName = SecurityContextHolder.getContext().getAuthentication().getName();
		
		mode.addAttribute("accountName", accountName);
		
		
		return "user/home";
		
	}
}
