package com.so.daoimpl;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.so.dao.OrderDao;
import com.so.entity.OrderItem;
import com.so.entity.Orders;
import com.so.entity.Product;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class OrderDaoImplTest {
	@Autowired
	private OrderDao orderDao;

	@Test
	public void testSaveOrders() {
		List<Orders> selectOrder = orderDao.selectOrder(5);
		for (Orders orders : selectOrder) {
			System.out.println(orders);
		}
	}

	@Test
	public void testaveOrders() {
		List<Orders> selectOrder = orderDao.selectOrderByCidAndPage(5, 0, 3);
		for (Orders orders : selectOrder) {
			Set<OrderItem> orderItems = orders.getOrderItems();
			for (OrderItem orderItem : orderItems) {
				Product product = orderItem.getProduct();
			}
		}
	}
}
