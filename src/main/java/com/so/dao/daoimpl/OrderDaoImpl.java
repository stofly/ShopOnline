package com.so.dao.daoimpl;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.so.dao.OrderDao;
import com.so.dao.ProductDao;
import com.so.entity.OrderItem;
import com.so.entity.Orders;
import com.so.entity.Product;
import com.so.utils.PageHibernateCallback;
import com.sun.mail.imap.protocol.UID;

@Repository("orderDao")
@Transactional
public class OrderDaoImpl extends MyHibernateDaoSupport implements OrderDao {
	@Autowired
	private ProductDao productDao;

	/**
	 * 
	 * @Title: saveOrder
	 * @Description:持久层保存订单实现类
	 * @param order
	 */
	@Override
	public void saveOrders(Orders orders) {
		// TODO Auto-generated method stub
		try {
			this.getHibernateTemplate().save(orders);
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
	}

	/**
	 * 
	 * @Title: saveOrderItem
	 * @Description: 持久层保存订单项实现类
	 * @param orderItem
	 */
	@Override
	public void saveOrderItem(OrderItem orderItem) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(orderItem);
	}

	@Override
	public void selectOrderByStates() {
		// TODO Auto-generated method stub

	}

	/**
	 * 
	 * @Title: selectOrder
	 * @Description: 持久层根据用户id查询订单项实现类
	 * @param uid
	 * @return
	 */
	@Override
	public List<Orders> selectOrder(Integer uid) {
		// TODO Auto-generated method stub
		List<Orders> orderList = null;
		String hql = "from Orders where uid =?";
		try {
			orderList = (List<Orders>) this.getHibernateTemplate().find(hql, uid);
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
		return orderList;
	}

	/**
	 * 
	 * @Title: selectOrderByCidAndPage
	 * @Description: 持久层根据用户id查询订单项实现类（实现分页）
	 * @param uid
	 * @param startIndex
	 * @param pageSize
	 * @return
	 */
	@Override
	public List<Orders> selectOrderByCidAndPage(Integer uid, int startIndex, int pageSize) {
		// TODO Auto-generated method stub
		String hql = "from Orders where uid =?";
		List<Orders> list = (List<Orders>) this.getHibernateTemplate()
				.execute((HibernateCallback<Product>) new PageHibernateCallback(hql, new Object[] { uid }, startIndex,
						pageSize));
		if (list != null && list.size() > 0) {
			return list;
		}
		return null;
	}

	/**
	 * 
	 * @Title: selectOrder
	 * @Description: 根据订单id查询订单实现类
	 * @param oid
	 * @return
	 */
	@Override
	public Orders selectOrder(String oid) {
		// TODO Auto-generated method stub
		List<Orders> orderList = null;
		String hql = "from Orders where oid =?";
		try {
			orderList = (List<Orders>) this.getHibernateTemplate().find(hql, oid);
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
		return orderList.get(0);
	}
}
