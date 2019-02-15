package com.so.service;

import com.so.entity.User;

public interface UserService {
	void addUser(User user) throws Exception;

	boolean activeUser(String activeCode) throws Exception;

	String login(User user) throws Exception;

	User loginUser(User user) throws Exception;
}
