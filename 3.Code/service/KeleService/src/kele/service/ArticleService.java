package kele.service;

import kele.entity.Article;
import kele.util.Pager;

public interface ArticleService {

	int insert(Article article);
	
	boolean update(Article article);
	
	boolean delete(int id);
	
	Article getById(int id);
	
	Pager getPagedList(Pager pager);
	
}
