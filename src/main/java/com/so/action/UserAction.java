package com.so.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.so.entity.User;
import com.so.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@SuppressWarnings("serial")
@Controller("userAction")
@ParentPackage(value = "struts-default")
@Scope("prototype")
@Namespace(value = "/")
public class UserAction extends ActionSupport implements ModelDriven<User> {
	@Autowired
	private UserService userService;
	User user = new User();

	@Override
	public User getModel() {
		if (user != null) {
			return user;
		}
		return null;
	}

	/**
	 * 
	 * @Title: addUser
	 * @Description:用户注册
	 * @return
	 * @throws Exception String
	 */
	@Action(value = "userAction_addUser", results = {
			@Result(name = SUCCESS, type = "dispatcher", location = "/jsp/info.jsp") })
	public String addUser() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		userService.addUser(user);
		request.setAttribute("msg", "用户注册成功，请到您填写的邮箱进行激活！！！");
		return SUCCESS;
	}

	/**
	 * 
	 * @Title: activeUser
	 * @Description:用户激活
	 * @return
	 * @throws Exception String
	 */
	@Action(value = "userAction_activeUser", results = {
			@Result(name = SUCCESS, type = "dispatcher", location = "/jsp/login.jsp"),
			@Result(name = NONE, type = "dispatcher", location = "/jsp/info.jsp") })
	public String activeUser() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		String activeCode = request.getParameter("activeCode");
		boolean activeUser = userService.activeUser(activeCode);
		if (activeUser) {
			request.setAttribute("msg", "用户激活成功，请登录！！！");
			return SUCCESS;
		} else {
			request.setAttribute("msg",
					"<a href=\"http://localhost:8080/ShoppingOnline/uiAction_rejester.action\"><h3 style=\"text-align: center;\">激活码失效，请重新注册！！！</h3></a>");
			return NONE;
		}
	}

	/**
	 * 
	 * @Title: login
	 * @Description: 用户登录
	 * @return
	 * @throws Exception String
	 */
	@Action(value = "userAction_login", results = {
			@Result(name = SUCCESS, type = "dispatcher", location = "/jsp/index.jsp"),
			@Result(name = NONE, type = "dispatcher", location = "/jsp/login.jsp") })
	public String login() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		String login2 = userService.login(user);
		if (login2.equals("a")) {
			User loginUser = userService.loginUser(user);
			session.setAttribute("user", loginUser);
			return SUCCESS;
		}
		if (login2.equals("b")) {
			request.setAttribute("msg", "用户未激活！！！");
			return NONE;
		}
		if (login2.equals("c")) {
			request.setAttribute("msg", "用户名或密码错误！！！");
			return NONE;
		}
		return null;
	}

	@Action(value = "userAction_logout", results = {
			@Result(name = SUCCESS, type = "redirect", location = "/index.jsp") })
	public String logout() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		// 清除整个session
		session.removeAttribute("user");
		return SUCCESS;
	}
}