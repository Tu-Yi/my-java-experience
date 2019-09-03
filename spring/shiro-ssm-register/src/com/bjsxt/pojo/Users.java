package com.bjsxt.pojo;

import java.io.Serializable;
import java.util.List;

import org.aspectj.weaver.AjAttribute.PrivilegedAttribute;

public class Users implements Serializable {
	private Integer id;
	private String username;
	private String password;
	private String password_salt;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPassword_salt() {
		return password_salt;
	}
	public void setPassword_salt(String password_salt) {
		this.password_salt = password_salt;
	}
	@Override
	public String toString() {
		return "Users [id=" + id + ", username=" + username + ", password=" + password + ", password_salt="
				+ password_salt + "]";
	}
	
	
	
}
