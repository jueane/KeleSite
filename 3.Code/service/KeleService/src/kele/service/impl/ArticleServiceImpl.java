package kele.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kele.dao.ArticleDao;
import kele.entity.Article;
import kele.service.ArticleService;
import kele.util.Pager;

@Service
@Transactional
public class ArticleServiceImpl implements ArticleService{

	@Autowired
	private ArticleDao articleDao;
	
	@Override
	public int insert(Article article) {
		return articleDao.insert(article);
	}

	@Override
	public boolean update(Article article) {
		return articleDao.update(article);
	}

	@Override
	public boolean delete(int id) {
		return articleDao.delete(id);
	}

	@Override
	public Article getById(int id) {
		return articleDao.getById(id);
	}

	@Override
	public Pager getPagedList(Pager pager) {
		return articleDao.getPagedList(pager);
	}

}
