package com.dc.function.user.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
import org.springframework.stereotype.Service;

import com.dc.function.user.dao.AccountRepository;
import com.dc.function.user.dao.RoleRepository;
import com.dc.function.user.model.AccountInfo;
import com.dc.function.user.model.Privilege;
import com.dc.function.user.model.Role;
import com.dc.function.user.model.UserInfo;

@Service
public class UserService extends JdbcDaoImpl{

/*	9.3.1 What is authentication in Spring Security?
	private static AuthenticationManager am = new SampleAuthenticationManager();*/
	
	
	@Autowired
	DataSource dataSource;
	
	@Autowired 
	AccountRepository accountRepository;
	
	 @Autowired
	    private RoleRepository roleRepository;
	 
	 @PostConstruct
		private void initialize() {
			setDataSource(dataSource);
		}
	 

	public void signUp(UserInfo account){
		/*UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(account, null, account.getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(authentication);*/
		//SecurityContextHolder.getContext()
	}
	
/*	private Authentication authenticate(UserInfo account) {
		return new UsernamePasswordAuthenticationToken(account, null, account.getAuthorities());
	}*/

	
	public UserDetails loadUserByUsername(String accountName) throws UsernameNotFoundException {
		 AccountInfo account = accountRepository.getAccountByAccountName(accountName);
		 if (account == null) {
	            return new org.springframework.security.core.userdetails.User(
	              " ", " ", true, true, true, true, 
	              getAuthorities(Arrays.asList(
	                roleRepository.findByName("ROLE_USER"))));
	        }
	 
	        return new org.springframework.security.core.userdetails.User(
	        		account.getAccountName(), account.getPassWord(), account.isEnable(), true, true, 
	          true, getAuthorities(account.getRoles()));
	}
	
	
/*	 private org.springframework.security.core.userdetails.User createSpringUser(AccountInfo user) {
		 
		 
	        return new org.springframework.security.core.userdetails.User(
	                user.getAccountName(),
	                user.getPassWord(),
	                Collections.singleton(createAuthority(user)));
	    }*/
	 
	/* private GrantedAuthority createAuthority(AccountInfo user) {
	       // return new SimpleGrantedAuthority(user.getRole());
		 
		 new SimpleGrantedAuthority()
	    }*/
	 
	 private Collection<? extends GrantedAuthority> getAuthorities(
		      Collection<Role> roles) {
		  
		        return getGrantedAuthorities(getPrivileges(roles));
		    }
	 
	 private List<String> getPrivileges(Collection<Role> roles) {
		  
	        List<String> privileges = new ArrayList<>();
	        List<Privilege> collection = new ArrayList<>();
	        for (Role role : roles) {
	            collection.addAll(role.getPrivileges());
	        }
	        for (Privilege item : collection) {
	            privileges.add(item.getName());
	        }
	        return privileges;
	    }
	 
	 private List<GrantedAuthority> getGrantedAuthorities(List<String> privileges) {
		 List<GrantedAuthority> authorities = new ArrayList<>();
		for (String privilege : privileges) {
		 authorities.add(new SimpleGrantedAuthority(privilege));
		}
		return authorities;
	}
}
