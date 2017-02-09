package com.dc.function.user.service;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
import org.springframework.stereotype.Service;

import com.dc.function.user.dao.AccountRepository;
import com.dc.function.user.model.AccountInfo;
import com.dc.function.user.model.UserInfo;

@Service
public class UserService extends JdbcDaoImpl{

	
	@Autowired 
	AccountRepository accountRepository;
	
	public void signUp(UserInfo account){
		SecurityContextHolder.getContext().setAuthentication(authenticate(account));
		//SecurityContextHolder.getContext()
	}
	
/*	private Authentication authenticate(UserInfo account) {
		return new UsernamePasswordAuthenticationToken(account, null, account.getAuthorities());
	}*/

	
	public UserDetails loadUserByUsername(String accountName) throws UsernameNotFoundException {
		 AccountInfo account = accountRepository.getAccountByAccountName(accountName);
		    return createSpringUser(account); 
	}
	
	
	 private org.springframework.security.core.userdetails.User createSpringUser(AccountInfo user) {
	        return new org.springframework.security.core.userdetails.User(
	                user.getAccountName(),
	                user.getPassWord(),
	                Collections.singleton(createAuthority(user)));
	    }
	 
	 private GrantedAuthority createAuthority(AccountInfo user) {
	        return new SimpleGrantedAuthority(user.getRole());
	    }
}
