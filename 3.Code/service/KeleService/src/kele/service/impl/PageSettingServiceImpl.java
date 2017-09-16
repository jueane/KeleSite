package kele.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kele.dao.PageSettingDao;
import kele.entity.PageSetting;
import kele.service.PageSettingService;

@Service
@Transactional
public class PageSettingServiceImpl implements PageSettingService {

	@Autowired
	private PageSettingDao pageSettingDao;

	@Override
	public int insert(PageSetting pageSetting) {
		return pageSettingDao.insert(pageSetting);
	}

	@Override
	public boolean update(PageSetting pageSetting) {
		return pageSettingDao.update(pageSetting);
	}

	@Override
	public boolean delete(int id) {
		return pageSettingDao.delete(id);
	}

	@Override
	public PageSetting getById(int id) {
		return pageSettingDao.getById(id);
	}

	@Override
	public List<PageSetting> getByType(PageSettingType type) {
		return pageSettingDao.getByType(type.value());
	}

	@Override
	public List<PageSetting> getAllList() {
		return pageSettingDao.getAllList();
	}


}
