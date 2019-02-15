package com.so.service;

import java.util.List;

import com.so.entity.PageModel;
import com.so.entity.Product;

public interface ProductService {
	/**
	 * 
	 * @Title: findHotProduct
	 * @Description: 查询所有热门商品接口
	 * @return
	 * @throws Exception List<Product>
	 */
	public List<Product> findHotProduct() throws Exception;

	/**
	 * 
	 * @Title: findHNewProduct
	 * @Description: 查询所有最新商品接口
	 * @return
	 * @throws Exception List<Product>
	 */
	public List<Product> findHNewProduct() throws Exception;

	/**
	 * 
	 * @Title: findProductById
	 * @Description: 根据商品id查询商品接口
	 * @param pid
	 * @return Product
	 */
	public Product findProductById(String pid);

	/**
	 * 
	 * @Title: findProductByCidAndPage
	 * @Description: 根据当前传入的分类id及首页数据进行查询
	 * @param cid
	 * @param currentPageNum
	 * @return PageModel
	 */
	public PageModel findProductByCidAndPage(int cid, int currentPageNum);

}
