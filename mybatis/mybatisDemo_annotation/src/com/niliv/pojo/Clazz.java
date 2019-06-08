package com.niliv.pojo;

import java.io.Serializable;
import java.util.List;

public class Clazz implements Serializable {
	
	private int id;
	private String name;
	private String room;
	@Override
	public String toString() {
		return "Clazz [id=" + id + ", name=" + name + ", room=" + room + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRoom() {
		return room;
	}
	public void setRoom(String room) {
		this.room = room;
	}
	
	
	
}
