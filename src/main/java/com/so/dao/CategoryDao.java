package com.so.dao;

import java.util.List;

import com.so.entity.Category;

public interface CategoryDao {
	/**
	 * 
	 * @Title: selectAllCategory
	 * @Description: 查询所有商品分类接口
	 * @return
	 * @throws Exception List<Category>
	 */
	public List<Category> selectAllCategory() throws Exception;
	/**
	 * @Title: insertCategory  
	 * @Description:插入商品分类接口 
	 * @param cname
	 * Integer
	 */
	public Integer insertCategory(String cname);
	/**
	 * @Title: selectCategoryById  
	 * @Description: 持久层根据商品分类查询商品分类 
	 * @return
	 * Category
	 */
	public Category selectCategoryById(Integer id);
	/**
	 * 
	 * @Title: updateCategoryById  
	 * @Description: 持久层根据商品分类修改商品分类 
	 * @param id
	 * @return
	 * Integer
	 */
	public void updateCategoryById(Category category);
	/**
	 * @Title: deleteCategorysById  
	 * @Description:持久层根据id删除商品
	 * @param id
	 * void
	 */
	public void deleteCategorysById(Integer id);

}
