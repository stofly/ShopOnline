package com.so.service.serviceimpl;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.so.entity.User;
import com.so.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class UserServiceImplTest {
	@Resource(name = "userService")
	private UserService userService;

	@Test
	public void testAddUserService() throws Exception {
		User user = new User();
		user.setName("bll");
		userService.addUser(user);
	}

	@Test
	public void testloginUser() throws Exception {
		User user = new User();
		user.setUsername("ccc");
		user.setPassword("ccc");
		User loginUser = userService.loginUser(user);
		System.out.println(loginUser);
	}

}
