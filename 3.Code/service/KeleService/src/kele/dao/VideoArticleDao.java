package kele.dao;

import kele.entity.VideoArticle;
import kele.util.Pager;

public interface VideoArticleDao {

	int insert(VideoArticle article);
	
	boolean update(VideoArticle article);
	
	boolean delete(int id);
	
	VideoArticle getById(int id);
	
	Pager getPagedList(Pager pager);
	
}
