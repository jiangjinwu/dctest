package com.dc.function.user.model;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

 @Entity
 @Table(name="users_roles")
public class Role {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @ManyToMany(mappedBy = "roles")
    private Collection<AccountInfo> accountInfos;
    
    
    
    
 
    public Role(String name) {
		super();
		this.name = name;
	}





	@ManyToMany
    @JoinTable(
        name = "roles_privileges", 
        joinColumns = @JoinColumn(
          name = "role_id", referencedColumnName = "id"), 
        inverseJoinColumns = @JoinColumn(
          name = "privilege_id", referencedColumnName = "id"))
    private Collection<Privilege> privileges;





	public Long getId() {
		return id;
	}





	public void setId(Long id) {
		this.id = id;
	}





	public String getName() {
		return name;
	}





	public void setName(String name) {
		this.name = name;
	}





	





	public Collection<AccountInfo> getAccountInfos() {
		return accountInfos;
	}





	public void setAccountInfos(Collection<AccountInfo> accountInfos) {
		this.accountInfos = accountInfos;
	}





	public Collection<Privilege> getPrivileges() {
		return privileges;
	}





	public void setPrivileges(Collection<Privilege> privileges) {
		this.privileges = privileges;
	}  
	
	
	
	
}
