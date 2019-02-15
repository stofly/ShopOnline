package com.so.action;

import com.opensymphony.xwork2.ActionSupport;
import com.so.entity.Cart;
import com.so.entity.CartItem;
import com.so.entity.OrderItem;
import com.so.entity.Orders;
import com.so.entity.PageModel;
import com.so.entity.Product;
import com.so.entity.User;
import com.so.service.OrderService;
import com.so.service.ProductService;
import com.so.utils.UUIDUtils;

import java.util.Date;

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
@Controller("orderAction")
@ParentPackage(value = "struts-default")
@Scope("prototype")
@Namespace(value = "/")
public class OrderAction extends ActionSupport {

	@Autowired
	private OrderService orderService;

	@Action(value = "orderAction_subOrder", results = {
			@Result(name = SUCCESS, type = "dispatcher", location = "/jsp/order_info.jsp"),
			@Result(name = NONE, type = "dispatcher", location = "/jsp/info.jsp"), })
	public String subOrder() throws Exception {
		// 将购物车的东西以订单的信息形式保存
		HttpServletRequest request = ServletActionContext.getRequest();
		// 确认用户在登录状态
		User user = (User) request.getSession().getAttribute("user");
		if (user == null) {
			request.setAttribute("msg", "请再登录后下单！！！");
			return NONE;
		}
		// 获取购物车
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		// 创建订单
		Orders orders = new Orders();
		orders.setOid(UUIDUtils.getCode());
		orders.setOrdertime(new Date());
		orders.setTotal(cart.getTotal());
		orders.setStates(1);
		orders.setUser(user);
		// 创建订单项
		for (CartItem cartItem : cart.getCartItems()) {
			OrderItem orderItem = new OrderItem();
			orderItem.setItemid(UUIDUtils.getCode());
			orderItem.setQuantity(cartItem.getNum());
			orderItem.setTotal(cartItem.getSubTotal());
			orderItem.setProduct(cartItem.getProduct());
			orderItem.setOrders(orders);
			orders.getOrderItems().add(orderItem);
		}
		// 调用业务层功能，保存订单
		orderService.save(orders);
		// 清空购物车
		cart.clearCart();
		// 将订单放入request中
		request.setAttribute("order", orders);
		// 转发至订单 信息页
		return SUCCESS;
	}

	@Action(value = "orderAction_findOrderByCidAndPage", results = {
			@Result(name = SUCCESS, type = "dispatcher", location = "/jsp/order_list.jsp") })
	public String findOrderByCidAndPage() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		Integer num = Integer.parseInt(request.getParameter("num"));
		User user = (User) request.getSession().getAttribute("user");
		Integer uid = user.getUid();
		PageModel pageModel = orderService.findOrderByCidAndPage(num, uid);
		request.setAttribute("page", pageModel);
		return SUCCESS;
	}

	@Action(value = "orderAction_findOrderByOid", results = {
			@Result(name = SUCCESS, type = "dispatcher", location = "/jsp/order_info.jsp") })
	public String findOrderByOid() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		String oid = request.getParameter("oid");
		Orders orders = orderService.findOrderByOid(oid);
		request.setAttribute("order", orders);
		return SUCCESS;
	}
	@Action(value = "orderAction_subOrderCost", results = {
			@Result(name = SUCCESS, type = "dispatcher", location = "/jsp/order_info.jsp") })
	public String subOrderCost() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		return SUCCESS;
	}
}