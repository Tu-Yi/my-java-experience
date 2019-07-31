package com.niliv.pojo;

public class Data {
	private int id;
	private String title;
	private String remark;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "Data [id=" + id + ", title=" + title + ", remark=" + remark + "]";
	}
	public Data(int id, String title, String remark) {
		super();
		this.id = id;
		this.title = title;
		this.remark = remark;
	}
	public Data() {
		super();
	}
	
	
}
