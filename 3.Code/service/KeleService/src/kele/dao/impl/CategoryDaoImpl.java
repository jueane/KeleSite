package kele.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kele.dao.CategoryDao;
import kele.entity.Category;
import kele.entity.SysUser;
import kele.util.Pager;

@Repository
public class CategoryDaoImpl implements CategoryDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public int insert(Category category) {
		Session session = sessionFactory.getCurrentSession();
		session.save(category);
		return category.getId();
	}

	@Override
	public boolean update(Category category) { 
		Session session = sessionFactory.getCurrentSession();
		session.update(category);
		return true;
	}

	@Override
	public boolean delete(int id) {
		Session session = sessionFactory.getCurrentSession();
		Category category = (Category) session.createCriteria(Category.class).add(Restrictions.eq("deleted", false)).add(Restrictions.idEq(id)).uniqueResult();
		if(category==null){
			return false;
		}
		category.setDeleted(true);
		return true;
	}

	@Override
	public Category getById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Category category = (Category) session.createCriteria(Category.class).add(Restrictions.eq("deleted", false)).add(Restrictions.idEq(id)).uniqueResult();
		return category;
	}

	@Override
	public Pager getPagedList(Pager pager) {
		Session session = sessionFactory.openSession();
		// 设置总记录数
		Criteria crtTotal = session.createCriteria(Category.class).add(Restrictions.eq("deleted", false));
		int total =Integer.parseInt(crtTotal.setProjection(Projections.rowCount()).uniqueResult().toString());
		// 查询列表
		Criteria crt = session.createCriteria(Category.class).add(Restrictions.eq("deleted", false));
		crt.addOrder(Order.desc("id"));
		crt.setFirstResult((pager.getPageIndex() - 1) * pager.getPageSize());
		crt.setMaxResults(pager.getPageSize());
		pager.setList(crt.list());
		pager.setTotal(total);
		return pager;
	}

}
