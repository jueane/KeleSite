package kele.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kele.dao.VideoArticleDao;
import kele.entity.VideoArticle;
import kele.util.Pager;

@Repository
public class VideoArticleDaoImpl implements VideoArticleDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public int insert(VideoArticle article) {
		Session session = sessionFactory.getCurrentSession();
		session.save(article);
		return article.getId();
	}

	@Override
	public boolean update(VideoArticle article) {
		Session session = sessionFactory.getCurrentSession();
		session.update(article);
		return true;
	}

	@Override
	public boolean delete(int id) {
		Session session = sessionFactory.getCurrentSession();
		VideoArticle entity = (VideoArticle) session.createCriteria(VideoArticle.class).add(Restrictions.idEq(id)).uniqueResult();
		if (entity == null) {
			return false;
		}
		entity.setDeleted(true);
		return true;
	}

	@Override
	public VideoArticle getById(int id) {
		Session session = sessionFactory.getCurrentSession();
		return (VideoArticle) session.createCriteria(VideoArticle.class).add(Restrictions.idEq(id)).uniqueResult();
	}

	@Override
	public Pager getPagedList(Pager pager) {
		Session session = sessionFactory.getCurrentSession();
		// 设置总记录数
		Criteria crtTotal = session.createCriteria(VideoArticle.class);
		crtTotal.add(Restrictions.eq("deleted", false));
		int total = Integer.parseInt(crtTotal.setProjection(Projections.rowCount()).uniqueResult().toString());
		// 查询列表
		Criteria crt = session.createCriteria(VideoArticle.class);
		crt.add(Restrictions.eq("deleted", false));
		crt.addOrder(Order.desc("id"));
		crt.setFirstResult((pager.getPageIndex() - 1) * pager.getPageSize());
		crt.setMaxResults(pager.getPageSize());
		pager.setList(crt.list());
		pager.setTotal(total);
		return pager;
	}
	
}
