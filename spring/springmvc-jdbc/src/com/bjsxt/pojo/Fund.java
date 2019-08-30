package com.bjsxt.pojo;

public class Fund {
	private String fname;
	private int count;
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public Fund() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Fund(String fname, int count) {
		super();
		this.fname = fname;
		this.count = count;
	}
	@Override
	public String toString() {
		return "Fund [fname=" + fname + ", count=" + count + "]";
	}
	
	
}
