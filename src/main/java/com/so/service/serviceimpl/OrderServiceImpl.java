package com.so.service.serviceimpl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.so.dao.OrderDao;
import com.so.entity.OrderItem;
import com.so.entity.Orders;
import com.so.entity.PageModel;
import com.so.service.OrderService;

@Service("orderService")
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderDao orderDao;

	/**
	 * @Title: save
	 * @Description:业务层保存订单接口实现类
	 * @param order
	 */
	@Override
	public void save(Orders orders) {
		// TODO Auto-generated method stub
		try {
			orderDao.saveOrders(orders);
			Set<OrderItem> orderItems = orders.getOrderItems();
			for (OrderItem orderItem : orderItems) {
				orderDao.saveOrderItem(orderItem);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/**
	 * @Title: findOrderByCidAndPage
	 * @Description: 业务层查询订单接口实现类
	 * @param num
	 * @param uid
	 * @return
	 */
	@Override
	public PageModel findOrderByCidAndPage(int num, Integer uid) {
		// TODO Auto-generated method stub
		// 新建PageModel
		PageModel pageModel = null;
		try {
			int totalRecords = orderDao.selectOrder(uid).size();
			pageModel = new PageModel(num, totalRecords, 4);
			List<Orders> ordersList = orderDao.selectOrderByCidAndPage(uid, pageModel.getStartIndex(),
					pageModel.getPageSize());
			pageModel.setList(ordersList);
			pageModel.setUrl("orderAction_findOrderByCidAndPage");
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
		return pageModel;
	}

	@Override
	public Orders findOrderByOid(String oid) {
		// TODO Auto-generated method stub
		Orders order = orderDao.selectOrder(oid);
		return order;
	}
}
