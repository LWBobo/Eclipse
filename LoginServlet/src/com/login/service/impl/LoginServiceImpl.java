package com.login.service.impl;

import com.login.dao.LoginDao;
import com.login.dao.impl.LoginDaoImpl;
import com.login.pojo.User;
import com.login.service.LoginService;

public class LoginServiceImpl implements LoginService{
	//创建Dao层过度向
	LoginDao ld=new LoginDaoImpl();
	//校验用户登录信息
	@Override
	public User checkLoginService(String uname, String pwd) {
		
		return ld.checkLoginDao(uname, pwd);
	}
	//校验Cookie信息
	@Override
	public User checkUidService(String uid) {
		return ld.checkUidDao(uid);
	}
	
}
