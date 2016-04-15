package com.duopei.others.test.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.util.Factory;
import org.junit.Assert;
import org.junit.Test;

public class LoginLogoutTest {

	@Test
	public void TestHelloWorld() {
		// 获取SecurityManager工厂，
		Factory<org.apache.shiro.mgt.SecurityManager> fac = new IniSecurityManagerFactory("classpath:shiro.ini") ;
		//Factory<org.apache.shiro.mgt.SecurityManager> fac = new IniSecurityManagerFactory("classpath:shiro_realm.ini") ;
		// 得到SecurityManager，并绑定给SecurityUtil
		org.apache.shiro.mgt.SecurityManager securityManager = fac.getInstance();
		SecurityUtils.setSecurityManager(securityManager);
		//3得到Subject及创建用户和密码身份验证Token（即用户身份、凭证）
		org.apache.shiro.subject.Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken("zhang","123");
		try{
			//登录 即验证身份
			subject.login(token);
		}catch(AuthenticationException ex){
			// 身份验证失败
			ex.printStackTrace();
		}
		
		Assert.assertEquals(true,subject.isAuthenticated()); // 断言 用户已登录
		
		subject.logout();
		
		
	}

}
