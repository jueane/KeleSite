package kele.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kele.dao.PageSettingDao;
import kele.entity.PageSetting;

@Repository
public class PageSettingDaoImpl implements PageSettingDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public int insert(PageSetting pageSetting) {
		Session session=sessionFactory.getCurrentSession();
		session.save(pageSetting);
		return pageSetting.getId();
	}

	@Override
	public boolean update(PageSetting pageSetting) {
		Session session = sessionFactory.getCurrentSession();
		session.update(pageSetting);
		return true;
	}

	@Override
	public boolean delete(int id) {
		Session session = sessionFactory.getCurrentSession();
		PageSetting category = (PageSetting) session.createCriteria(PageSetting.class).add(Restrictions.eq("deleted", false)).add(Restrictions.idEq(id)).uniqueResult();
		if (category == null) {
			return false;
		}
		category.setDeleted(true);
		return true;
	}

	@Override
	public PageSetting getById(int id) {
		Session session = sessionFactory.getCurrentSession();
		return (PageSetting) session.createCriteria(PageSetting.class).add(Restrictions.eq("deleted", false)).add(Restrictions.idEq(id)).uniqueResult();
	}

	@Override
	public List<PageSetting> getByType(int type) {
		Session session = sessionFactory.getCurrentSession();
		return (List<PageSetting>) session.createCriteria(PageSetting.class).add(Restrictions.eq("deleted", false)).add(Restrictions.eq("type", type)).list();
	}

	@Override
	public List<PageSetting> getAllList() {
		Session session=sessionFactory.getCurrentSession();
		return (List<PageSetting>)session.createCriteria(PageSetting.class).add(Restrictions.eq("deleted",false)).list();
	}
	

}
