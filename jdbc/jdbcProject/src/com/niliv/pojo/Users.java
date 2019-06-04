package com.niliv.pojo;

/**
 * 用户表实体
 * @author Administrator
 * @Date 2019-06-04 16:07:56
 * @Description 
 *
 */
public class Users {
	private String userid;
	private String nickname;
	private int score;
	private String sex;
	private String createtime;
	
	public String getUserid() {
		return userid;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}

	
	
}
