package com.dc.function.user.service;

import java.util.List;

import org.springframework.context.ApplicationContextException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;

public class UserDetailService extends JdbcDaoImpl {



	public UserDetailService() {
		 
	}

	@Override
	protected void addCustomAuthorities(String username, List<GrantedAuthority> authorities) {
		// TODO Auto-generated method stub
		super.addCustomAuthorities(username, authorities);
	}

	@Override
	protected UserDetails createUserDetails(String username, UserDetails userFromUserQuery,
			List<GrantedAuthority> combinedAuthorities) {
		// TODO Auto-generated method stub
		return super.createUserDetails(username, userFromUserQuery, combinedAuthorities);
	}

	@Override
	protected String getAuthoritiesByUsernameQuery() {
		// TODO Auto-generated method stub
		return super.getAuthoritiesByUsernameQuery();
	}

	@Override
	protected boolean getEnableAuthorities() {
		// TODO Auto-generated method stub
		return super.getEnableAuthorities();
	}

	@Override
	protected boolean getEnableGroups() {
		// TODO Auto-generated method stub
		return super.getEnableGroups();
	}

	@Override
	protected String getRolePrefix() {
		// TODO Auto-generated method stub
		return super.getRolePrefix();
	}

	@Override
	public String getUsersByUsernameQuery() {
		// TODO Auto-generated method stub
		return super.getUsersByUsernameQuery();
	}

	@Override
	protected void initDao() throws ApplicationContextException {
		// TODO Auto-generated method stub
		super.initDao();
	}

	@Override
	protected boolean isUsernameBasedPrimaryKey() {
		// TODO Auto-generated method stub
		return super.isUsernameBasedPrimaryKey();
	}

	@Override
	protected List<GrantedAuthority> loadGroupAuthorities(String username) {
		// TODO Auto-generated method stub
		return super.loadGroupAuthorities(username);
	}

	@Override
	protected List<GrantedAuthority> loadUserAuthorities(String username) {
		// TODO Auto-generated method stub
		return super.loadUserAuthorities(username);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return super.loadUserByUsername(username);
	}

	@Override
	protected List<UserDetails> loadUsersByUsername(String username) {
		// TODO Auto-generated method stub
		return super.loadUsersByUsername(username);
	}

	@Override
	public void setAuthoritiesByUsernameQuery(String queryString) {
		// TODO Auto-generated method stub
		super.setAuthoritiesByUsernameQuery(queryString);
	}

	@Override
	public void setEnableAuthorities(boolean enableAuthorities) {
		// TODO Auto-generated method stub
		super.setEnableAuthorities(enableAuthorities);
	}

	@Override
	public void setEnableGroups(boolean enableGroups) {
		// TODO Auto-generated method stub
		super.setEnableGroups(enableGroups);
	}

	@Override
	public void setGroupAuthoritiesByUsernameQuery(String queryString) {
		// TODO Auto-generated method stub
		super.setGroupAuthoritiesByUsernameQuery(queryString);
	}

	@Override
	public void setRolePrefix(String rolePrefix) {
		// TODO Auto-generated method stub
		super.setRolePrefix(rolePrefix);
	}

	@Override
	public void setUsernameBasedPrimaryKey(boolean usernameBasedPrimaryKey) {
		// TODO Auto-generated method stub
		super.setUsernameBasedPrimaryKey(usernameBasedPrimaryKey);
	}

	@Override
	public void setUsersByUsernameQuery(String usersByUsernameQueryString) {
		// TODO Auto-generated method stub
		super.setUsersByUsernameQuery(usersByUsernameQueryString);
	}

	
}
