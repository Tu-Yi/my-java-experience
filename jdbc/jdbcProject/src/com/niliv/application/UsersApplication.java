package com.niliv.application;

import java.util.ArrayList;
import java.util.List;

import com.niliv.pojo.Users;
import com.niliv.service.UsersService;
import com.niliv.service.impl.UsersServiceImpl;

public class UsersApplication {
	public static void main(String[] args) {
		
		UsersService usersService = new UsersServiceImpl();
		List<Users> users = new ArrayList<Users>();
		
		//批量插入数据
//		int[] arr = usersService.insertUsersBatch(1000, 200, 3,"2018-01-01 00:00:00","2018-12-31 23:59:59");
//		System.out.println(arr);
		
		//根据用户ID删除数据
//		int flag = usersService.dropUsers("999");
//		System.out.println(flag);
		
		//根据用户ID修改用户积分
//		Users users = new Users();
//		users.setScore(200);
//		users.setUserid("1");
//		int flag = usersService.updateUsers(users);
//		System.out.println(flag);
		
		//查出指定月份注册的用户
//		users = usersService.queryByMonth("05");
		
		//根据ID查出指定用户的信息
//		users = usersService.queryById("998");
		
		//查出积分大于某个值的用户信息
		users = usersService.queryByScore(100);
		
		for (Users user : users) {
			System.out.println(user.getUserid() + " " + user.getNickname() + " " + user.getScore() + " " + user.getCreatetime());
		}
		
	}
	
	
}
