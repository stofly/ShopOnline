package com.so.service.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.so.dao.UserDao;
import com.so.entity.User;
import com.so.service.UserService;
import com.so.utils.MailUtils;
import com.so.utils.UUIDUtils;

@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;

	/**
	 * 
	 * @Title: addUser
	 * @Description: 添加成功并发送激活码
	 * @param user
	 * @throws Exception
	 */
	@Override
	public void addUser(User user) throws Exception {
		// TODO Auto-generated method stub
		if (user != null) {
			// 确保用户为未激活状态
			user.setState(0);
			// 生成激活码
			user.setCode(UUIDUtils.getCode());
			userDao.save(user);
			String emailMsg = "恭喜您注册成功，请复制下面的连接到浏览器进行激活账户http://localhost:8080/ShoppingOnline/userAction_activeUser?activeCode="
					+ user.getCode();
			MailUtils.sendMail(user.getEmail(), emailMsg);
		}
	}

	/**
	 * 
	 * @Title: activeUser
	 * @Description:根据激活码查询用户的存在性、状态修改、激活码的清空
	 * @param activeCode
	 * @return
	 * @throws Exception
	 */
	@Override
	public boolean activeUser(String activeCode) throws Exception {
		// TODO Auto-generated method stub
		User activeUser = userDao.activeUser(activeCode);
		if (activeUser != null) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 
	 * @Title: login
	 * @Description: 用户登录
	 * @param user
	 * @return
	 * @throws Exception
	 */
	@Override
	public String login(User user) throws Exception {
		// TODO Auto-generated method stub
		if (user != null) {
			String loginCheck = userDao.loginCheck(user);
			return loginCheck;
		} else {
			return null;
		}
	}

	/**
	 * 
	 * @Title: loginUser
	 * @Description: 查询用户
	 * @param user
	 * @return
	 * @throws Exception
	 */
	@Override
	public User loginUser(User user) throws Exception {
		// TODO Auto-generated method stub
		if (user != null) {
			User loginUser = userDao.loginUser(user);
			return loginUser;
		} else {
			return null;
		}
	}
}
