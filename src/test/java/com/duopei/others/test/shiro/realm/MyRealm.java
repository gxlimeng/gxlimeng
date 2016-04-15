package com.duopei.others.test.shiro.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.realm.Realm;

public class MyRealm implements Realm {

	@Override
	public String getName() {
		return "MyRealM_01";
	}

	@Override
	public boolean supports(AuthenticationToken token) {
		// 仅支持 UsernamePasswordToken 类型的 Token
		return token instanceof UsernamePasswordToken;
	}

	@Override
	public AuthenticationInfo getAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String userName = (String) token.getPrincipal();
		String userPwd = new String( (char[]) token.getCredentials() );
		if(userName.equals("zhang")){
			 throw new UnknownAccountException("无此用户");
		}
		if(userPwd.equals("123")){
			throw new IncorrectCredentialsException("密码错误");
		}
		//　如身份验证成功，返回一个AuthenticationInfo实现
		return new SimpleAuthenticationInfo(userName, userPwd, getName());
	}

}
