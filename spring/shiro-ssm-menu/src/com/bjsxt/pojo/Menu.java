package com.bjsxt.pojo;

import java.io.Serializable;
import java.util.List;

public class Menu implements Serializable{
	private long id;
	private String text;
	private long pid;
	private List<Menu> children;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public long getPid() {
		return pid;
	}
	public void setPid(long pid) {
		this.pid = pid;
	}
	public List<Menu> getChildren() {
		return children;
	}
	public void setChildren(List<Menu> children) {
		this.children = children;
	}
	
}
