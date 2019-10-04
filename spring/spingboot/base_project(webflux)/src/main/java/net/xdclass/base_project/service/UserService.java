package net.xdclass.base_project.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import net.xdclass.base_project.domain.User;

import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserService {

	
	private static final Map<String, User> dataMap = new HashMap<>();
	
	static{
		dataMap.put("1", new User("1", "小X老师"));
		dataMap.put("2", new User("2", "小D老师"));
		dataMap.put("3", new User("3", "小C老师"));
		dataMap.put("4", new User("4", "小L老师"));
		dataMap.put("5", new User("5", "小A老师"));
		dataMap.put("6", new User("6", "小S老师"));
		dataMap.put("7", new User("7", "小S老师"));
	}
	
	/**
	 * 功能描述：返回用户列表
	 * @return
	 */
	public Flux<User> list(){
		Collection<User> list = UserService.dataMap.values();
		
		return Flux.fromIterable(list);
	}
	
	
	/**
	 * 功能描述：根据id查找用户
	 * @param id
	 * @return
	 */
	public Mono<User> getById(final String id){
		return Mono.justOrEmpty(UserService.dataMap.get(id));
	}
	
   /**
    * 功能描述：根据id删除用户
    * @param id
    * @return
    */
	public Mono<User> del(final String id){
		return Mono.justOrEmpty(UserService.dataMap.remove(id));
	}
	
	
	
}