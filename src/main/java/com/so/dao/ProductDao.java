package com.so.dao;

import java.util.List;

import com.so.entity.Product;

public interface ProductDao {
	/**
	 * 
	 * @Title: selectHotProduct
	 * @Description:查询最热商品数据访问层接口
	 * @return
	 * @throws Exception List<Product>
	 */
	public List<Product> selectHotProduct() throws Exception;

	/**
	 * 
	 * @Title: selectNewProduct
	 * @Description:查询最新商品数据访问层接口
	 * @return
	 * @throws Exception List<Product>
	 */
	public List<Product> selectNewProduct() throws Exception;

	/**
	 * 
	 * @Title: selectProductById
	 * @Description: 根据商品id查询商品数据访问层接口
	 * @param pid
	 * @return Product
	 */
	public List<Product> selectProductById(String pid);

	/**
	 * 
	 * @Title: findProductTotalRecords
	 * @Description: 查询指定分类id下的所有产品
	 * @param cid
	 * @return int
	 */
	public List<Product> findProductTotalRecords(int cid);

	/**
	 * 
	 * @Title: findProductByCidAndPage
	 * @Description:根据指定的查询黁进行分页查询
	 * @param cid
	 * @param startIndex
	 * @param pageSize
	 * @return List<Product>
	 */
	public List<Product> findProductByCidAndPage(int cid, int startIndex, int pageSize);

}
