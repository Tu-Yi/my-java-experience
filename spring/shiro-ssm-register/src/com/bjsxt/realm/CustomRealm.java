package com.bjsxt.realm;

import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import com.bjsxt.mapper.IUserMapper;
import com.bjsxt.pojo.Users;
//自定义Realm
public class CustomRealm extends AuthorizingRealm {
	
	@Resource
	private IUserMapper mapper;
	//获取认证信息，完成身份认证
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		//根据表单传过来的用户名查询用户信息
		System.out.println(token.getPrincipal().toString());
		Users user = mapper.selectByUsername(token.getPrincipal().toString());
		System.out.println("batis");
		System.out.println(user);
		//用户名存在
		if(user!=null){
			//将String类型的salt转换为ByteSource类型
			ByteSource newSalt = ByteSource.Util.bytes(user.getPassword_salt());
			/**
			 * 该构造器参数为：表单中的用户名；该用户名对应的数据库中密码；盐值；realm名
			 */
			SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(token.getPrincipal(), user.getPassword(),newSalt, token.getPrincipal().toString());
			System.out.println(info);
			return info;
		}else{
			//用户名不存在
			return null;
		}
	}
	//授权
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		return null;
	}

}
