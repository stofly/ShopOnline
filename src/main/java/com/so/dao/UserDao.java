package com.so.dao;

import com.so.entity.User;

public interface UserDao {

	void save(User users) throws Exception;

	User activeUser(String activeCode) throws Exception;

	void uapdateStatus(User user) throws Exception;

	String loginCheck(User user) throws Exception;

	User loginUser(User user) throws Exception;
}
