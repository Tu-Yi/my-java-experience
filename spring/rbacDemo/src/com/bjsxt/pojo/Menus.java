package com.bjsxt.pojo;

import java.util.ArrayList;
import java.util.List;

public class Menus {

	private int menuid;
	private String menuname;
	private String menuurl;
	private int fatherid;
	private List<Funs> funs = new ArrayList<>();
	public List<Funs> getFuns() {
		return funs;
	}
	public void setFuns(List<Funs> funs) {
		this.funs = funs;
	}
	public int getMenuid() {
		return menuid;
	}
	public void setMenuid(int menuid) {
		this.menuid = menuid;
	}
	public String getMenuname() {
		return menuname;
	}
	public void setMenuname(String menuname) {
		this.menuname = menuname;
	}
	public String getMenuurl() {
		return menuurl;
	}
	public void setMenuurl(String menuurl) {
		this.menuurl = menuurl;
	}
	public int getFatherid() {
		return fatherid;
	}
	public void setFatherid(int fatherid) {
		this.fatherid = fatherid;
	}
	
}
