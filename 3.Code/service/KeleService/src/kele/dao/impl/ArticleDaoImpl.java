package kele.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kele.dao.ArticleDao;
import kele.entity.Article;
import kele.util.Pager;

@Repository
public class ArticleDaoImpl implements ArticleDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public int insert(Article article) {
		Session session = sessionFactory.getCurrentSession();
		session.save(article);
		return article.getId();
	}

	@Override
	public boolean update(Article article) {
		Session session = sessionFactory.getCurrentSession();
		session.update(article);
		return false;
	}

	@Override
	public boolean delete(int id) {
		Session session = sessionFactory.getCurrentSession();
		Article article = (Article) session.createCriteria(Article.class).add(Restrictions.eq("deleted", false)).add(Restrictions.idEq(id)).uniqueResult();
		article.setDeleted(true);
		return false;
	}

	@Override
	public Article getById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Article article = (Article) session.createCriteria(Article.class).add(Restrictions.eq("deleted", false)).add(Restrictions.idEq(id)).uniqueResult();
		return article;
	}

	@Override
	public Pager getPagedList(Pager pager) {
		Session session = sessionFactory.getCurrentSession();
		// 设置总记录数
		Criteria crtTotal = session.createCriteria(Article.class);
		crtTotal.add(Restrictions.eq("deleted", false));
		int total = Integer.parseInt(crtTotal.setProjection(Projections.rowCount()).uniqueResult().toString());
		// 查询列表
		Criteria crt = session.createCriteria(Article.class);
		crt.add(Restrictions.eq("deleted", false));
		crt.addOrder(Order.desc("id"));
		crt.setFirstResult((pager.getPageIndex() - 1) * pager.getPageSize());
		crt.setMaxResults(pager.getPageSize());
		pager.setList(crt.list());
		pager.setTotal(total);
		return pager;
	}

}
