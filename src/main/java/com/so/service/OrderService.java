package com.so.service;

import com.so.entity.Orders;
import com.so.entity.PageModel;

public interface OrderService {
	/**
	 * 
	 * @Title: save
	 * @Description:业务层保存订单接口
	 * @param order void
	 */
	void save(Orders orders);

	/**
	 * @Title: findOrderByCidAndPage
	 * @Description: 业务层查询订单接口
	 * @param num
	 * @param uid
	 * @return PageModel
	 */
	PageModel findOrderByCidAndPage(int num, Integer uid);

	/**
	 * @Title: findOrderByOid
	 * @Description: 业务层根据订单编号查询订单接口
	 * @param oid
	 * @return Orders
	 */
	Orders findOrderByOid(String oid);

}
