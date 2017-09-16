package kele.dao;

import kele.entity.Article;
import kele.util.Pager;

public interface ArticleDao {

	int insert(Article article);
	
	boolean update(Article article);
	
	boolean delete(int id);
	
	Article getById(int id);
	
	Pager getPagedList(Pager pager);
	
}
	
	
	
	
