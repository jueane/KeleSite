package kele.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kele.dao.CategoryDao;
import kele.entity.Category;
import kele.service.CategoryService;
import kele.util.Pager;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	private CategoryDao categoryDao;
	
	@Override
	public int insert(Category category) {
		return categoryDao.insert(category);
	}

	@Override
	public boolean update(Category category) {
		return categoryDao.update(category);
	}

	@Override
	public boolean delete(int id) {
		return categoryDao.delete(id);
	}

	@Override
	public Category getById(int id) {
		return categoryDao.getById(id);
	}

	@Override
	public Pager getPagedList(Pager pager) {
		return categoryDao.getPagedList(pager);
	}

}
