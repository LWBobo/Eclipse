package com.logintest.dao;

import com.logintest.pojo.User;

public interface LoginDao {
		User checkLoginDao(String uname, String pwd);
}
