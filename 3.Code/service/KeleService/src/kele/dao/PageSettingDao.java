package kele.dao;

import java.util.List;

import kele.entity.PageSetting;

public interface PageSettingDao {
	int insert(PageSetting pageSetting);

	boolean update(PageSetting pageSetting);
	
	boolean delete(int id);

	PageSetting getById(int id);

	List<PageSetting> getByType(int type);
	
	List<PageSetting> getAllList();

}
