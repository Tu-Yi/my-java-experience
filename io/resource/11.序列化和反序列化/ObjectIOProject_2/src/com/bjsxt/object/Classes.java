package com.bjsxt.object;

import java.io.Serializable;
import java.util.ArrayList;

public class Classes implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8407410133605121812L;
	private String className;//°à¼¶Ãû³Æ
	private ArrayList<Student> al;
	private String address;
	public Classes() {
		super();
	}
	public Classes(String className, ArrayList<Student> al) {
		super();
		this.className = className;
		this.al = al;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public ArrayList<Student> getAl() {
		return al;
	}
	public void setAl(ArrayList<Student> al) {
		this.al = al;
	}
}
