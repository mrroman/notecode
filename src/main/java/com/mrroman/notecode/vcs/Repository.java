package com.mrroman.notecode.vcs;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.URL;

import com.mrroman.notecode.account.Account;

@Entity
public class Repository {

	@Id
	@GeneratedValue
	private Integer id;
	
	@NotEmpty
	private String name;
	
	@URL
	@NotEmpty
	private String address;
	
	@Email
	private String careEmail;
	
	@ManyToOne
	private Account account;
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getCareEmail() {
		return careEmail;
	}
	
	public void setCareEmail(String careEmail) {
		this.careEmail = careEmail;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
		
	public Account getAccount() {
		return account;
	}
	
	public void setAccount(Account account) {
		this.account = account;
	}
}
