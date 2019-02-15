package com.so.service.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.so.dao.CategoryDao;
import com.so.entity.Category;
import com.so.service.CategoryService;

@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	private CategoryDao categoryDao;

	@Override
	public List<Category> findAllCategory() throws Exception {
		// TODO Auto-generated method stub
		List<Category> categorys = categoryDao.selectAllCategory();
		try {
			if (categorys != null) {
				return categorys;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
		return null;
	}

	@Override
	public Integer saveCategory(String cname) {
		// TODO Auto-generated method stub
		Integer insertCategory = null;
		try {
			insertCategory = categoryDao.insertCategory(cname);
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
		return insertCategory;
	}

	@Override
	public Category findCategorysById(Integer id) {
		// TODO Auto-generated method stub
		Category selectCategoryById = null;
		try {
			selectCategoryById = categoryDao.selectCategoryById(id);
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
		return selectCategoryById;
	}

	@Override
	public void updateCategoryById(Category category) {
		// TODO Auto-generated method stub
		try {
			categoryDao.updateCategoryById(category);
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
	}

	@Override
	public void deleteCategorysById(Integer id) {
		// TODO Auto-generated method stub
		try {
			categoryDao.deleteCategorysById(id);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
}
