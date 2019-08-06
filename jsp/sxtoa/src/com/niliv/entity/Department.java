package com.niliv.entity;

import java.io.Serializable;

/**
 * 部门类
 * @author Administrator
 * @Date 2019-08-03 10:13:06
 * @Description 
 *
 */
public class Department implements Serializable,Comparable<Department> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8603754709357193123L;
	private int deptno;
	private String deptName;
	private String location;
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	@Override
	public String toString() {
		return "Department [deptno=" + deptno + ", deptName=" + deptName + ", location=" + location + "]";
	}
	public Department(int deptno, String deptName, String location) {
		super();
		this.deptno = deptno;
		this.deptName = deptName;
		this.location = location;
	}
	public Department() {
		super();
	}
	
	public Department(int deptno, String deptName) {
		super();
		this.deptno = deptno;
		this.deptName = deptName;
	}
	@Override
	public int compareTo(Department o) {
		return this.deptno-o.deptno;
	}
}
