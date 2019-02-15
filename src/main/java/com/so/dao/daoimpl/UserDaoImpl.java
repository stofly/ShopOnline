package com.so.dao.daoimpl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.so.dao.UserDao;
import com.so.entity.User;

@Repository("userDao")
@Transactional
public class UserDaoImpl extends MyHibernateDaoSupport implements UserDao {

	/**
	 * 
	 * @Title: save
	 * @Description: 添加用户
	 * @param users
	 * @throws Exception
	 */
	@Override
	public void save(User users) throws Exception {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(users);
	}

	/**
	 * 
	 * @Title: uapdateStatus
	 * @Description: 激活后修改用户状态
	 */
	@Override
	public void uapdateStatus(User user) throws Exception {
		// TODO Auto-generated method stub
		user.setState(1);
		user.setCode(null);
		this.getHibernateTemplate().update(user);
	}

	/**
	 * @Title: activeUser
	 * @Description:根据激活码查询用户
	 * @param activeCode
	 */
	@Override
	public User activeUser(String activeCode) throws Exception {
		// TODO Auto-generated method stub
		try {
			List<User> userList = (List<User>) this.getHibernateTemplate().find("from User u where u.code=?",
					activeCode);
			if (userList.get(0) != null) {
				this.uapdateStatus(userList.get(0));
				return userList.get(0);
			} else {
				return null;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
		return null;

	}

	/**
	 * 
	 * @Title: loginCheck
	 * @Description: 用户登录检测
	 * @param user
	 * @return
	 */
	@Override
	public String loginCheck(User user) {
		// TODO Auto-generated method stub
		// 用户名或密码错误
		try {
			String hql = "from User where username='" + user.getUsername() + "'and password='" + user.getPassword()
					+ "'";
			List<User> userList = (List<User>) this.getHibernateTemplate().find(hql);
			if (userList.get(0) != null) {
				if (userList.get(0).getState() == 1) {
					// 用户登录成功
					return "a";
				} else {
					// 用户未激活
					return "b";
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
		return "c";
	}

	/**
	 * 
	 * @Title: loginCheck
	 * @Description: 用户登录查询
	 * @param user
	 * @return
	 */
	@Override
	public User loginUser(User user) {
		// TODO Auto-generated method stub
		try {
			String hql = "from User where username='" + user.getUsername() + "'and password='" + user.getPassword()
					+ "'and state=" + 1 + "";
			List<User> userList = (List<User>) this.getHibernateTemplate().find(hql);
			if (userList.get(0) != null) {
				return userList.get(0);
			} else {
				return null;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
		return null;
	}
	
	
	
}