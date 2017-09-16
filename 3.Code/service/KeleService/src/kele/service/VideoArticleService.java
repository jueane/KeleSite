package kele.service;

import kele.entity.VideoArticle;
import kele.util.Pager;

public interface VideoArticleService {

	int insert(VideoArticle article);
	
	boolean update(VideoArticle article);
	
	boolean delete(int id);
	
	VideoArticle getById(int id);
	
	Pager getPagedList(Pager pager);
	
}
