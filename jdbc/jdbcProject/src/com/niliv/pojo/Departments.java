package com.niliv.pojo;
/**
 * modual
 * @author Administrator
 * @Date 2019-05-30 19:44:28
 * @Description 
 *
 */
public class Departments {
	
	private int DEPARTMENT_ID;
	private String DEPARTMENT_NAME;
	private int MANAGER_ID;
	private int LOCATION_ID;
	
	public int getDEPARTMENT_ID() {
		return DEPARTMENT_ID;
	}
	public void setDEPARTMENT_ID(int dEPARTMENT_ID) {
		DEPARTMENT_ID = dEPARTMENT_ID;
	}
	public String getDEPARTMENT_NAME() {
		return DEPARTMENT_NAME;
	}
	public void setDEPARTMENT_NAME(String dEPARTMENT_NAME) {
		DEPARTMENT_NAME = dEPARTMENT_NAME;
	}
	public int getMANAGER_ID() {
		return MANAGER_ID;
	}
	public void setMANAGER_ID(int mANAGER_ID) {
		MANAGER_ID = mANAGER_ID;
	}
	public int getLOCATION_ID() {
		return LOCATION_ID;
	}
	public void setLOCATION_ID(int lOCATION_ID) {
		LOCATION_ID = lOCATION_ID;
	}
}
