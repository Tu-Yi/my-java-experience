package com.niliv.pojo;

public class Url {
	private int urlid;
	private String location;
	private String remark;
	public int getUrlid() {
		return urlid;
	}
	public void setUrlid(int urlid) {
		this.urlid = urlid;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "Url [urlid=" + urlid + ", location=" + location + ", remark=" + remark + "]";
	}
	public Url(int urlid, String location, String remark) {
		super();
		this.urlid = urlid;
		this.location = location;
		this.remark = remark;
	}
	public Url() {
		super();
	}
	
	
}
