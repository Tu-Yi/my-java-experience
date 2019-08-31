package com.bjsxt.pojo;

import java.util.ArrayList;
import java.util.List;

public class Roles {
	private int roleid;
	private String rolename;
	private List<Menus> menus = new ArrayList<>();
	public List<Menus> getMenus() {
		return menus;
	}
	public void setMenus(List<Menus> menus) {
		this.menus = menus;
	}
	public int getRoleid() {
		return roleid;
	}
	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}
	public String getRolename() {
		return rolename;
	}
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
	
}
