package com.so.action;

import com.opensymphony.xwork2.ActionSupport;
import com.so.entity.Cart;
import com.so.entity.CartItem;
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
@Controller("cartAction")
@ParentPackage(value = "struts-default")
@Scope("prototype")
@Namespace(value = "/")
public class CartAction extends ActionSupport {

	@Autowired
	private ProductService productService;

	@Action(value = "cartAction_addCartItem", results = {
			@Result(name = SUCCESS, type = "redirect", location = "/jsp/cart.jsp") })
	public String addCartItem() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		// 判断是否有购物车
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		if (cart == null) {
			cart = new Cart();
			request.getSession().setAttribute("cart", cart);
		}
		// 获取购物车模型所需的购物项数量和每个商品的id
		String pid = request.getParameter("pid");
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		Product product = productService.findProductById(pid);
		// 将购物项放在购物车中
		CartItem cartItem = new CartItem();
		cartItem.setNum(quantity);
		cartItem.setProduct(product);
		cart.addCartItemToCar(cartItem);
		return SUCCESS;
	}

	@Action(value = "cartAction_deleteCartItem", results = {
			@Result(name = SUCCESS, type = "redirect", location = "/jsp/cart.jsp") })
	public String deleteCartItem() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		int pid = Integer.parseInt(request.getParameter("id"));
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		cart.removeCartItem(pid);
		request.getSession().setAttribute("cart", cart);
		return SUCCESS;
	}

	@Action(value = "cartAction_clearCartItem", results = {
			@Result(name = SUCCESS, type = "redirect", location = "/jsp/cart.jsp") })
	public String clearCartItem() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		String pid = request.getParameter("id");
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		cart.clearCart();
		return SUCCESS;
	}
}