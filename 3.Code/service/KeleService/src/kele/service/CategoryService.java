package kele.service;

import kele.entity.Category;
import kele.util.Pager;

public interface CategoryService {

	int insert(Category category);
	
	boolean update(Category category);
	
	boolean delete(int id);
	
	Category getById(int id);
	
	Pager getPagedList(Pager pager);
	

}
