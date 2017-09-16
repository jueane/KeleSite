package kele.service;

import java.util.List;

import kele.entity.PageSetting;

public interface PageSettingService {
	
	int insert(PageSetting pageSetting);

	boolean update(PageSetting pageSetting);
	
	boolean delete(int id);
	
	PageSetting getById(int id);
	
	List<PageSetting> getByType(PageSettingType type);
	
	List<PageSetting> getAllList();

	
	
	public enum PageSettingType{
		homePicture("首页图片",1),
		homeArticle("首页文章",2),
		homeIntroduction("首页介绍",3),
		companySummary("公司简介",4);
		private int value=0;
		private String name;
		private PageSettingType(String name,int value){
			this.name=name;
			this.value=value;
		}
		public int value(){
			return this.value;
		}
			
		
	};
	
}
