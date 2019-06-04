package com.niliv.service.impl;


import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.niliv.commons.Tools;
import com.niliv.dao.DepartmentsDao;
import com.niliv.dao.UsersDao;
import com.niliv.dao.impl.DepartmentsDaoImpl;
import com.niliv.dao.impl.UsersDaoImpl;
import com.niliv.pojo.Users;
import com.niliv.service.UsersService;

public class UsersServiceImpl implements UsersService {
	private static Set<String> nameSet = new HashSet<>();
	
	@Override
	public int[] insertUsersBatch(int count, int maxS, int nameLength,String startDate,String endDate) {
		
		List<Users> users = new ArrayList<Users>();
		
		for (int i = 0; i < count; i++) {
			Users user = new Users();
			user.setUserid(i+"");
			//生成3个字母的唯一的昵称
			String nickName = Tools.randomString(nameLength);
			while(!nameSet.add(nickName)) {
				nickName = Tools.randomString(nameLength);
			}
			user.setNickname(nickName);
			//分数随机0-200的整数
			user.setScore((int)(Math.random()*(maxS)));
			//奇偶-男女
			user.setSex(i%2==0 ? "男":"女");
			//生成2018年的随机时间
			user.setCreatetime(Tools.randomDate(startDate,endDate));
			
			users.add(user);
		}

		UsersDao usersDao = new UsersDaoImpl();
		return usersDao.insertUsersBatch(users);
	}

	@Override
	public int dropUsers(String usersid) {
		
		UsersDao usersDao = new UsersDaoImpl();
		return usersDao.deleteUsersById(usersid);
	}

	@Override
	public int updateUsers(Users users) {
		UsersDao usersDao = new UsersDaoImpl();
		return usersDao.updateUsers(users);
	}

	@Override
	public List<Users> queryByMonth(String month) {
		UsersDao usersDao = new UsersDaoImpl();
		return usersDao.queryByMonth(month);
	}

	@Override
	public List<Users> queryById(String userid) {
		UsersDao usersDao = new UsersDaoImpl();
		return usersDao.queryById(userid);
	}

	@Override
	public List<Users> queryByScore(int score) {
		UsersDao usersDao = new UsersDaoImpl();
		return usersDao.queryByScore(score);
	}
}
