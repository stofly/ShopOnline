package com.so.dao.daoimpl;

import java.util.List;

import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.so.dao.ProductDao;
import com.so.entity.Product;
import com.so.utils.PageHibernateCallback;

@Repository("productDao")
@Transactional
public class ProductDaoImpl extends MyHibernateDaoSupport implements ProductDao {

	/**
	 * 
	 * @Title: selectHotProduct
	 * @Description:查询热门商品
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Product> selectHotProduct() throws Exception {
		// TODO Auto-generated method stub
		List<Product> hotProductList = null;
		String hql = "from  Product WHERE pflag=0 and ishot=1 ORDER BY pdate DESC";
//		hotProductList = (List<Product>) this.getHibernateTemplate().find(hql);
		hotProductList = (List<Product>) this.getHibernateTemplate()
				.execute((HibernateCallback<Product>) new PageHibernateCallback(hql, null, 0, 9));
		if (hotProductList != null && hotProductList.size() > 0) {
			return hotProductList;
		} else {
			return null;
		}
//		return hotProductList;
	}

	/**
	 * 
	 * @Title: selectNewProduct
	 * @Description: 查询最新商品
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Product> selectNewProduct() throws Exception {
		// TODO Auto-generated method stub
		List<Product> NewProductList = null;
		String hql = "from  Product WHERE pflag=0 ORDER BY pdate DESC";
//		NewProductList = (List<Product>) this.getHibernateTemplate().find(hql);
		NewProductList = (List<Product>) this.getHibernateTemplate()
				.execute((HibernateCallback<Product>) new PageHibernateCallback(hql, null, 0, 9));
		if (NewProductList != null && NewProductList.size() > 0) {
			return NewProductList;
		} else {
			return null;
		}
	}

	/**
	 * 
	 * @Title: selectProductById
	 * @Description: 根据商品id进行查询
	 * @param pid
	 * @return
	 */
	@Override
	public List<Product> selectProductById(String pid) {
		// TODO Auto-generated method stub
		List<Product> productList = null;
		Integer id = Integer.parseInt(pid);
		String hql = "from  Product WHERE pid=?";
		try {
			productList = (List<Product>) this.getHibernateTemplate().find(hql, id);
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
		return productList;
	}

	/**
	 * 
	 * @Title: findProductTotalRecords
	 * @Description: 根据商品分类查询所对应的数量
	 * @param cid
	 * @return
	 */
	@Override
	public List<Product> findProductTotalRecords(int cid) {
		// TODO Auto-generated method stub
		List<Product> productList = null;
		try {
			String hql = "from  Product where cid =?";
			productList = (List<Product>) this.getHibernateTemplate().find(hql, cid);
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
		return productList;
	}

	/**
	 * 
	 * @Title: findProductByCidAndPage
	 * @Description: 根据商品进行分页查询
	 * @param cid
	 * @param startIndex
	 * @param pageSize
	 * @return
	 */
	@Override
	public List<Product> findProductByCidAndPage(int cid, int startIndex, int pageSize) {
		// TODO Auto-generated method stub
		String hql = "from  Product where cid =?";
		List<Product> list = (List<Product>) this.getHibernateTemplate()
				.execute((HibernateCallback<Product>) new PageHibernateCallback(hql, new Object[] { cid }, startIndex,
						pageSize));
		if (list != null && list.size() > 0) {
			return list;
		}
		return null;
	}

}
