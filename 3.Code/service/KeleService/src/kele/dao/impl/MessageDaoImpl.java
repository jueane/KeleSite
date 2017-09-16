package kele.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import kele.dao.MessageDao;
import kele.entity.Message;
import kele.util.Pager;

@Repository
public class MessageDaoImpl implements MessageDao{

	@Autowired	
	private SessionFactory sessionFactory;
	
	@Override
	public int insert(Message message) {
		Session session=sessionFactory.getCurrentSession();
		session.save(message);
		return message.getId();
	}

	@Override
	public boolean update(Message message) {
		Session session=sessionFactory.getCurrentSession();
		session.update(message);
		return true;
	}

	@Override
	public boolean delete(int id) {
		Session session=sessionFactory.getCurrentSession();
		Message message=(Message)session.createCriteria(Message.class).add(Restrictions.eq("deleted", false)).add(Restrictions.idEq(id)).uniqueResult();
		if(message==null){
			return false;
		}
		message.setDeleted(true);
		return true;
	}

	@Override
	public Message getById(int id) {
		Session session=sessionFactory.getCurrentSession();
		return (Message)session.createCriteria(Message.class).add(Restrictions.eq("deleted", false)).add(Restrictions.idEq(id)).uniqueResult();		
	}

	@Override
	public Pager getPagedList(Pager pager) {
		Session session = sessionFactory.getCurrentSession();
		// 设置总记录数
		Criteria crtTotal = session.createCriteria(Message.class).add(Restrictions.eq("deleted", false));
		int total = Integer.parseInt(crtTotal.setProjection(Projections.rowCount()).uniqueResult().toString());
		// 查询列表
		Criteria crt = session.createCriteria(Message.class).add(Restrictions.eq("deleted", false));
		crt.addOrder(Order.desc("id"));
		crt.setFirstResult((pager.getPageIndex() - 1) * pager.getPageSize());
		crt.setMaxResults(pager.getPageSize());
		pager.setList(crt.list());
		pager.setTotal(total);
		return pager;
	}

}
