package com.niliv.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.niliv.dao.UsersDao;
import com.niliv.pojo.Users;

public class UsersDaoImpl extends BaseDaoImpl implements UsersDao {
	/**
	 * 实现dao
	 */
	@Override
	public int[] insertUsersBatch(List<Users> users) {
		
		String sql = "INSERT INTO users VALUES(?,?,?,?,?)";
		List<Object[]> objList = new ArrayList<Object[]>();
		for (Users user : users) {
			Object[] paramObjects = new Object[] {user.getUserid(),user.getNickname(),
					user.getScore(),user.getSex(), user.getCreatetime()};
			objList.add(paramObjects);
		}
		return this.excuteBatch(sql, objList);
	}

	@Override
	public int deleteUsersById(String userid) {
		String sqlString = "delete from users where userid = ?";
		Object[] paramObjects = new Object[] {userid};
		
		return this.executeUpdate(sqlString, paramObjects);
	}

	@Override
	public int updateUsers(Users users) {
		String sqlString = "update users set score = ? where userid = ?";
		Object[] paramObjects = new Object[] {users.getScore(),users.getUserid()};
		
		return this.executeUpdate(sqlString, paramObjects);
	}

	@Override
	public List<Users> queryByMonth(String month) {
		String sql = "select * from users where DATE_FORMAT(createtime,'%m') = ?";
        return this.find(sql, new Object[] {month},Users.class);
	}

	@Override
	public List<Users> queryById(String userid) {
		String sql = "select * from users where userid = ?";
        return this.find(sql, new Object[] {userid},Users.class);
	}

	@Override
	public List<Users> queryByScore(int score) {
		String sql = "select * from users where score > ?";
        return this.find(sql, new Object[] {score},Users.class);
	}



}
