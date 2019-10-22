package com.logintest.service.impl;

import com.logintest.dao.LoginDao;
import com.logintest.dao.LoginDaoImpl;
import com.logintest.pojo.User;
import com.logintest.service.LoginService;

public class LoginServiceImpl implements LoginService{
	//创建DAO层过渡对象
	LoginDao ld = new LoginDaoImpl();

	@Override
	public User checkLoginService(String uname, String pwd) {

		
		return ld.checkLoginDao(uname, pwd);
	}



}
