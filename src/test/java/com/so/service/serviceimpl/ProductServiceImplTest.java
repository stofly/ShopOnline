package com.so.service.serviceimpl;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.so.entity.PageModel;
import com.so.service.ProductService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class ProductServiceImplTest {
	@Resource(name = "productService")
	private ProductService productService;

	@Test
	public void testFindProductById() {
		PageModel findProductByCidAndPage = productService.findProductByCidAndPage(1, 2);
		List list = findProductByCidAndPage.getList();
		System.out.println(findProductByCidAndPage.getTotalRecords());
		for (Object object : list) {
			System.out.println(object);
		}
	}
}
