package com.so.daoimpl;

 import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.so.dao.CategoryDao;
import com.so.entity.Category;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class CategoryDaoImplTest {
	@Autowired
	private CategoryDao categoryDao;

	@Test
	public void testSelectAllCategory() {
		try {
			List<Category> selectAllCategory = categoryDao.selectAllCategory();
			System.out.println(selectAllCategory);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void testSaveCategory() {
		Integer insertCategory = categoryDao.insertCategory("书");
		System.out.println(insertCategory);
	}
	@Test
	public void testSelectCategory() {
		Category selectCategoryById = categoryDao.selectCategoryById(1);
		System.out.println(selectCategoryById);
	}
	@Test
	public void tesdeletetCategory() {
		categoryDao.deleteCategorysById(8);
	}
}
