package com.logintest.service;

import com.logintest.pojo.User;

public interface LoginService {
	
	
	User checkLoginService(String uname , String pwd);

	User checkUidService(String uid);

}
