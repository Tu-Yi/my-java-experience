package com.bjsxt.realm;

import java.util.List;

import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.bjsxt.pojo.Role;
import com.bjsxt.pojo.Users;
import com.bjsxt.service.IUserService;
//自定义Realm
public class CustomRealm extends AuthorizingRealm {
	
	@Autowired
	private IUserService userService;
	// 认证方法：获取认证信息
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) {
		
		try {
			//调用service
			//根据表单传过来的用户名查询用户信息
			System.out.println(token.getPrincipal().toString());
			Users user = userService.selectByUsername(token.getPrincipal().toString());
			System.out.println(user);
			if (user != null) {
				ByteSource newSalt = ByteSource.Util.bytes(user.getPassword_salt());
				AuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(user,
						user.getPassword(), newSalt, token.getPrincipal().toString());
				System.out.println(simpleAuthenticationInfo);
				return simpleAuthenticationInfo;
			} else {
				return null;
			} 
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// 授权方法：获取授权信息
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		Users user = (Users) principals.getPrimaryPrincipal();
		List<Role> roles = user.getRoles();
		for (Role role : roles) {
			info.addRole(role.getName());
		}
		return info;
	}

}
