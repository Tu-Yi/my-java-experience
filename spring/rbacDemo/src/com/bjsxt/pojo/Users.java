package com.bjsxt.pojo;

import java.util.ArrayList;
import java.util.List;

public class Users {
	private String username;
	private String userpwd;
	private Roles roles;
	private List<Menus> menus = new ArrayList<Menus>();
	private List<Funs> funs = new ArrayList<>();
	public List<Funs> getFuns() {
		return funs;
	}
	public void setFuns(List<Funs> funs) {
		this.funs = funs;
	}
	public List<Menus> getMenus() {
		return menus;
	}
	public void setMenus(List<Menus> menus) {
		this.menus = menus;
	}
	public Roles getRoles() {
		return roles;
	}
	public void setRoles(Roles roles) {
		this.roles = roles;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserpwd() {
		return userpwd;
	}
	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}
	
}
