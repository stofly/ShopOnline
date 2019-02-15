package com.so.dao.daoimpl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.so.dao.CategoryDao;
import com.so.entity.Category;

@Repository("categoryDao")
@Transactional
public class CategoryDaoImpl extends MyHibernateDaoSupport implements CategoryDao {

	@Override
	public List<Category> selectAllCategory() throws Exception {
		// TODO Auto-generated method stub
		List<Category> categoryList = (List<Category>) this.getHibernateTemplate().find("from Category");
		return categoryList;
	}

	@Override
	public Integer insertCategory(String cname) {
		// TODO Auto-generated method stub
		Integer integer = null;
		try {
			Category category = new Category();
			category.setCname(cname);
			integer = (Integer) this.getHibernateTemplate().save(category);
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
		return integer;
	}

	@Override
	public Category selectCategoryById(Integer id) {
		// TODO Auto-generated method stub
		List<Category> category = null;
		try {
			String hql = "from Category where cid=? ";
			category = (List<Category>) this.getHibernateTemplate().find(hql, id);
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
		return category.get(0);
	}

	@Override
	public void updateCategoryById(Category category) {
		// TODO Auto-generated method stub
		try {
			if (category != null) {
				this.getHibernateTemplate().update(category);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
	}

	@Override
	public void deleteCategorysById(Integer id) {
		// TODO Auto-generated method stub
		try {
			Category category = new Category();
			category.setCid(id);
			this.getHibernateTemplate().delete(category);
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}

	}

}
