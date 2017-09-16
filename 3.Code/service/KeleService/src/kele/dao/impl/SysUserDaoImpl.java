package kele.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import kele.dao.SysUserDao;
import kele.entity.*;
import kele.util.Pager;

@Repository
public class SysUserDaoImpl implements SysUserDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public int insert(SysUser user) {
		Session session = sessionFactory.getCurrentSession();
		session.save(user);
		return user.getId();
	}

	@Override
	public boolean update(SysUser sysUser) {
		Session session = sessionFactory.getCurrentSession();
		session.update(sysUser);
		return true;
	}

	@Override
	public boolean delete(int id) {
		Session session = sessionFactory.getCurrentSession();
		SysUser category = (SysUser) session.createCriteria(SysUser.class).add(Restrictions.eq("deleted", false)).add(Restrictions.idEq(id)).uniqueResult();
		if (category == null) {
			return false;
		}
		category.setDeleted(true);
		return true;
	}

	@Override
	public SysUser getById(int id) {
		Session session = sessionFactory.getCurrentSession();
		return (SysUser) session.createCriteria(SysUser.class).add(Restrictions.eq("deleted", false)).add(Restrictions.idEq(id)).uniqueResult();
	}

	@Override
	public Pager getPagedList(Pager pager) {
		Session session = sessionFactory.getCurrentSession();
		// 设置总记录数
		Criteria crtTotal = session.createCriteria(SysUser.class).add(Restrictions.eq("deleted", false));
		int total = Integer.parseInt(crtTotal.setProjection(Projections.rowCount()).uniqueResult().toString());
		// 查询列表
		Criteria crt = session.createCriteria(SysUser.class).add(Restrictions.eq("deleted", false));
		crt.addOrder(Order.desc("id"));
		crt.setFirstResult((pager.getPageIndex() - 1) * pager.getPageSize());
		crt.setMaxResults(pager.getPageSize());
		pager.setList(crt.list());
		pager.setTotal(total);
		return pager;
	}

	@Override
	public SysUser validate(SysUser user) {
		Session session = sessionFactory.getCurrentSession();
		SysUser readUser = (SysUser) session.createCriteria(SysUser.class).add(Restrictions.eq("deleted", false)).add(Restrictions.eq("username", user.getUsername())).uniqueResult();
		if (readUser != null && readUser.getPassword().equals(user.getPassword())) {
			return readUser;
		} else {
			return null;
		}
	}

}
