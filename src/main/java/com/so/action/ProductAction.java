package com.so.action;

import com.opensymphony.xwork2.ActionSupport;
import com.so.entity.PageModel;
import com.so.entity.Product;
import com.so.service.ProductService;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@SuppressWarnings("serial")
@Controller("productAction")
@ParentPackage(value = "struts-default")
@Scope("prototype")
@Namespace(value = "/")
public class ProductAction extends ActionSupport {
	@Autowired
	private ProductService productService;

	@Action(value = "productAction_findProductById", results = {
			@Result(name = SUCCESS, type = "dispatcher", location = "/jsp/product_info.jsp") })
	public String findProductById() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		String pid = request.getParameter("pid");
		Product product = productService.findProductById(pid);
		request.setAttribute("product", product);
		return SUCCESS;
	}

	@Action(value = "productAction_findProductByCidAndPage", results = {
			@Result(name = SUCCESS, type = "dispatcher", location = "/jsp/product_list.jsp") })
	public String findProductByCidAndPage() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		int cid = Integer.parseInt(request.getParameter("cid"));
		int num = Integer.parseInt(request.getParameter("num"));
		PageModel page = productService.findProductByCidAndPage(cid, num);
		request.setAttribute("page", page);
		return SUCCESS;
	}
}