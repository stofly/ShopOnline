package com.so.action;

import com.opensymphony.xwork2.ActionSupport;
import com.so.entity.Product;
import com.so.service.ProductService;

import java.util.List;

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
@Controller("uiAction")
@ParentPackage(value = "struts-default")
@Scope("prototype")
@Namespace(value = "/")
public class UiAction extends ActionSupport {
	@Autowired
	private ProductService productService;

	/**
	 * 
	 * @Title: rejester
	 * @Description: 跳转至注册页面
	 * @return String
	 */
	@Action(value = "uiAction_rejester", results = {
			@Result(name = SUCCESS, type = "redirect", location = "/jsp/register.jsp") })
	public String rejester() {
		System.out.println("跳转了。。。。");
		return SUCCESS;
	}

	@Action(value = "uiAction_login", results = {
			@Result(name = SUCCESS, type = "redirect", location = "/jsp/login.jsp") })
	public String login() {
		System.out.println("登录跳转了。。。。");
		return SUCCESS;
	}

	@Action(value = "indexAction", results = {
			@Result(name = SUCCESS, type = "dispatcher", location = "/jsp/index.jsp") })
	public String index() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		// 获取最新商品
		List<Product> newProduct = productService.findHNewProduct();
		// 获取最热商品
		List<Product> hotProduct = productService.findHotProduct();
		session.setAttribute("newProduct", newProduct);
		session.setAttribute("hotProduct", hotProduct);
		return SUCCESS;
	}
}