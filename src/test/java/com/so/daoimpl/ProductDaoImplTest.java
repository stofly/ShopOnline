package com.so.daoimpl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.so.dao.ProductDao;
import com.so.entity.Product;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class ProductDaoImplTest {
	@Autowired
	private ProductDao productDao;

	@Test
	public void testSelectHotProduct() throws Exception {
		List<Product> selectHotProduct = productDao.selectHotProduct();
		for (Product product : selectHotProduct) {
			System.out.println(product);
		}
	}

	@Test
	public void testSelectNewProduct() throws Exception {
		List<Product> selectHotProduct = productDao.selectNewProduct();
		for (Product product : selectHotProduct) {
			System.out.println(product);
		}

	}

	@Test
	public void testFindProductTotalRecords() throws Exception {
		List<Product> i = productDao.findProductTotalRecords(1);
		System.out.println(i);
	}

	@Test
	public void testSelectProductById() throws Exception {
		List<Product> findProductByCidAndPage = productDao.findProductByCidAndPage(1, 0, 5);
		for (Product product : findProductByCidAndPage) {
			System.out.println(product);
		}
	}
}
