package com.so.service;

import java.util.List;

import com.so.entity.Category;

public interface CategoryService {
	/**
	 * 
	 * @Title: findAllCategory
	 * @Description: 查询所有商品分类
	 * @return
	 * @throws Exception List<CategoryService>
	 */
	public List<Category> findAllCategory() throws Exception;

	/**
	 * 
	 * @Title: saveCategory
	 * @Description:保存新建分类
	 * @return Integer
	 */
	public Integer saveCategory(String cname);

	/**
	 * @Title: findCategorysById
	 * @Description: 业务层根据商品id查新商品接口
	 * @param id
	 * @return Category
	 */
	public Category findCategorysById(Integer id);

	/**
	 * 
	 * @Title: updateCategoryById
	 * @Description: 业务层根据商品分类id修改商品分类接口
	 * @param id
	 * @return Integer
	 */
	public void updateCategoryById(Category category);
	/**
	 * 
	 * @Title: deleteCategorysById  
	 * @Description:业务层根据商品分类id删除商品分类
	 * @param id
	 * void
	 */
	public void deleteCategorysById(Integer id);

}
