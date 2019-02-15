package com.so.daoimpl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.so.dao.UserDao;
import com.so.entity.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class UserDaoImplTest {
	@Autowired
	private UserDao userDao;

	@Test
	public void TestSave() throws Exception {
		User user = new User();
		user.setUsername("stf");
		userDao.save(user);
	}

	@Test
	public void TestActiveUser() throws Exception {
		User activeUser = userDao.activeUser("DD3A5D6E5C844676A04244048E7396B5");
		System.out.println(activeUser);
	}

	@Test
	public void TestloginCheck() throws Exception {
		User user = new User();
		user.setUsername("aaa");
		user.setPassword("aaa");
		String loginCheck = userDao.loginCheck(user);
		System.out.println(loginCheck);
	}

	@Test
	public void TestloginCheck2() throws Exception {
		User user = new User();
		user.setUsername("aaa");
		user.setPassword("aaa");
		User loginUser = userDao.loginUser(user);
		System.out.println(loginUser);
	}
}
