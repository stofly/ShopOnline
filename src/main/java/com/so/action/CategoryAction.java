package com.so.action;

import com.opensymphony.xwork2.ActionSupport;
import com.so.entity.Category;
import com.so.service.CategoryService;
import com.so.utils.JedisUtils;

import net.sf.json.JSONArray;
import redis.clients.jedis.Jedis;

import java.net.URLDecoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@SuppressWarnings("serial")
@Controller("categoryAction")
@ParentPackage(value = "struts-default")
@Scope("prototype")
@Namespace(value = "/")
public class CategoryAction extends ActionSupport {
	@Autowired
	private CategoryService categoryService;

	/**
	 * @Title: addUser
	 * @Description:查询所有商品分类
	 * @return
	 * @throws Exception String
	 */
	@Action(value = "categoryAction_findAllCategorys")
	public String findAllCategorys() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		List<Category> findAllCategory = categoryService.findAllCategory();
		String jsonStr = JSONArray.fromObject(findAllCategory).toString();
		response.setContentType("application/json;charset=utf-8");
		response.getWriter().print(jsonStr);
		return null;
	}

	@Action(value = "categoryAction_saveCategorys")
	public String saveCategorys() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpServletRequest request = ServletActionContext.getRequest();
		String cname = URLDecoder.decode(request.getParameter("cname"), "UTF-8");
		System.out.println(cname);
		Integer saveCategory = categoryService.saveCategory(cname);
		String jsonStr = JSONArray.fromObject(saveCategory).toString();
		response.setContentType("application/json;charset=utf-8");
		response.getWriter().print(jsonStr);
		return null;
	}

	@Action(value = "categoryAction_findCategorysById")
	public String findCategorysById() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpServletRequest request = ServletActionContext.getRequest();
		Integer id = Integer.parseInt(request.getParameter("id"));
		System.out.println(id);
		Category category = categoryService.findCategorysById(id);
		System.out.println(category.getCname());
		String jsonStr = JSONArray.fromObject(category).toString();
		response.setContentType("application/json;charset=utf-8");
		response.getWriter().print(jsonStr);
		return null;
	}

	@Action(value = "categoryAction_updateCategorysById")
	public String updateCategorysById() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpServletRequest request = ServletActionContext.getRequest();
		Integer id = Integer.parseInt(request.getParameter("id"));
		String cname = URLDecoder.decode(request.getParameter("cname"), "UTF-8");
		Category category = new Category();
		category.setCid(id);
		category.setCname(cname);
		categoryService.updateCategoryById(category);
		String jsonStr = JSONArray.fromObject(1).toString();
		response.setContentType("application/json;charset=utf-8");
		response.getWriter().print(jsonStr);
		return null;
	}

	@Action(value = "categoryAction_deleteCategorysById")
	public String deleteCategorysById() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpServletRequest request = ServletActionContext.getRequest();
		Integer id = Integer.parseInt(request.getParameter("id"));
		categoryService.deleteCategorysById(id);
		String jsonStr = JSONArray.fromObject(1).toString();
		response.setContentType("application/json;charset=utf-8");
		response.getWriter().print(jsonStr);
		return null;
	}
}