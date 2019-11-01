package com.logintest.dao;

import com.logintest.pojo.User;

public interface LoginDao {
		User checkLoginDao(String uname, String pwd);
		/** 根据编号获取信息*/
		User checkUidDao(String uid);
}
