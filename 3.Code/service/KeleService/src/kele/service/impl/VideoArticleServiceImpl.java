package kele.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kele.dao.VideoArticleDao;
import kele.entity.VideoArticle;
import kele.service.VideoArticleService;
import kele.util.Pager;

@Service
@Transactional
public class VideoArticleServiceImpl implements VideoArticleService{

	@Autowired
	private VideoArticleDao VideoArticleDao;
	
	@Override
	public int insert(VideoArticle VideoArticle) {
		return VideoArticleDao.insert(VideoArticle);
	}

	@Override
	public boolean update(VideoArticle VideoArticle) {
		return VideoArticleDao.update(VideoArticle);
	}

	@Override
	public boolean delete(int id) {
		return VideoArticleDao.delete(id);
	}

	@Override
	public VideoArticle getById(int id) {
		return VideoArticleDao.getById(id);
	}

	@Override
	public Pager getPagedList(Pager pager) {
		return VideoArticleDao.getPagedList(pager);
	}

}
