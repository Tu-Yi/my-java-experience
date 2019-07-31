package com.niliv.pojo;

public class Area {
	private int areaid;
	private String areaname;
	private int parentid;
	private int arealevel;
	private int status;
	private String spell;
	public Area(int areaid, String areaname, int parentid, int arealevel, int status, String spell) {
		super();
		this.areaid = areaid;
		this.areaname = areaname;
		this.parentid = parentid;
		this.arealevel = arealevel;
		this.status = status;
		this.spell = spell;
	}
	public Area() {
		super();
	}
	public int getAreaid() {
		return areaid;
	}
	public void setAreaid(int areaid) {
		this.areaid = areaid;
	}
	public String getAreaname() {
		return areaname;
	}
	public void setAreaname(String areaname) {
		this.areaname = areaname;
	}
	public int getParentid() {
		return parentid;
	}
	public void setParentid(int parentid) {
		this.parentid = parentid;
	}
	public int getArealevel() {
		return arealevel;
	}
	public void setArealevel(int arealevel) {
		this.arealevel = arealevel;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getSpell() {
		return spell;
	}
	public void setSpell(String spell) {
		this.spell = spell;
	}
	@Override
	public String toString() {
		return "Area [areaid=" + areaid + ", areaname=" + areaname + ", parentid=" + parentid + ", arealevel="
				+ arealevel + ", status=" + status + ", spell=" + spell + "]";
	}
}
