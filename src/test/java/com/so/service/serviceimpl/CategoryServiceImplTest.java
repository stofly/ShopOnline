package com.so.service.serviceimpl;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.so.entity.Category;
import com.so.service.CategoryService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class CategoryServiceImplTest {
	@Autowired
	private CategoryService categoryService;

	@Test
	public void testFindAllCategory() throws Exception {
		List<Category> findAllCategory = categoryService.findAllCategory();
		System.out.println(findAllCategory);
	}
}
