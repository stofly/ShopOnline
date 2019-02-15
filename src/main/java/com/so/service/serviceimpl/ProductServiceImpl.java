package com.so.service.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.so.dao.ProductDao;
import com.so.entity.PageModel;
import com.so.entity.Product;
import com.so.service.ProductService;

@Service("productService")
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductDao productDao;

	/**
	 * 
	 * @Title: findHotProduct
	 * @Description: 查询最热商品业务层
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Product> findHotProduct() throws Exception {
		// TODO Auto-generated method stub
		List<Product> selectHotProduct = null;
		try {
			selectHotProduct = productDao.selectHotProduct();
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}

		return selectHotProduct;
	}

	/**
	 * 
	 * @Title: findHNewProduct
	 * @Description: 查询最新商品实现
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Product> findHNewProduct() throws Exception {
		// TODO Auto-generated method stub
		List<Product> selectNewProduct = null;
		try {
			selectNewProduct = productDao.selectNewProduct();
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
		return selectNewProduct;
	}

	/**
	 * 
	 * @Title: findProductById
	 * @Description: 根据商品id查询商品实现
	 * @param pid
	 * @return
	 */
	@Override
	public Product findProductById(String pid) {
		// TODO Auto-generated method stub
		Product product = null;
		List<Product> selectProductById = productDao.selectProductById(pid);
		if (selectProductById != null) {
			product = selectProductById.get(0);
		}
		return product;
	}

	@Override
	public PageModel findProductByCidAndPage(int cid, int num) {
		// TODO Auto-generated method stub
		// 首先根据该分类id查询该类产品的所有产品数量
		List<Product> findProduct = null;
		PageModel pageModel = null;
		try {
			int totalRecords = productDao.findProductTotalRecords(cid).size();
			System.out.println(totalRecords);
			pageModel = new PageModel(num, totalRecords, 12);
			findProduct = productDao.findProductByCidAndPage(cid, pageModel.getStartIndex(), pageModel.getPageSize());
			pageModel.setList(findProduct);
			pageModel.setUrl("productAction_findProductByCidAndPage?cid=" + cid);
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
		return pageModel;

	}

}
