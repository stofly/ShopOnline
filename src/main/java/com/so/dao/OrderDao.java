package com.so.dao;

import java.util.List;

import com.so.entity.OrderItem;
import com.so.entity.Orders;

public interface OrderDao {
	/**
	 * 
	 * @Title: saveOrder
	 * @Description:持久层保存订单接口实现类
	 * @param order void
	 */
	void saveOrders(Orders orders);

	/**
	 * 
	 * @Title: saveOrderItem
	 * @Description: 持久层保存订单项接口实现类
	 * @param orderItem void
	 */
	void saveOrderItem(OrderItem orderItem);

	/**
	 * 
	 * @Title: selectOrder
	 * @Description:持久层查询所有订单 void
	 */
	List<Orders> selectOrder(Integer uid);

	/**
	 * @Title: selectOrder
	 * @Description:持久层跟据付款状态查询指定订单 void
	 */
	void selectOrderByStates();

	/**
	 * 
	 * @Title: selectOrderByCidAndPage
	 * @Description: 持久层跟据订单分页
	 * @param uid
	 * @param startIndex
	 * @param pageSize   void
	 */
	List<Orders> selectOrderByCidAndPage(Integer uid, int startIndex, int pageSize);

	Orders selectOrder(String oid);

}
