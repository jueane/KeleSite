package kele.ui.manage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kele.entity.PageSetting;
import kele.service.PageSettingService;
import kele.service.PageSettingService.PageSettingType;

@Controller
@RequestMapping("manage/pagesetting")
public class PageSettingManageController {

	@Autowired
	private PageSettingService pageSettingService;

	// 首页图片
	@RequestMapping
	public String index(ModelMap modelMap) {
		List<PageSetting> homeArticleList = pageSettingService.getByType(PageSettingType.homePicture);
		modelMap.put("entityList", homeArticleList);
		return "manage/freemarker/pagesetting/Index";
	}
	@RequestMapping(value = "indexCreate", method = RequestMethod.POST)
	public String indexCreate(PageSetting pageSetting) {		
		System.err.println(PageSettingType.homePicture.value());		
		pageSetting.setType(PageSettingType.homePicture.value());
		pageSettingService.insert(pageSetting);
		return "redirect:";
	}
	@RequestMapping("indexDelete")
	public String indexDelete(int id){
		try {
			pageSettingService.delete(id);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "redirect:";
	}

	// 首页文章
	@RequestMapping("homeArticle")
	public String homeArticle(ModelMap modelMap) {		
		List<PageSetting> homeArticlePageSettingList = pageSettingService.getByType(PageSettingType.homeArticle);
		modelMap.put("entityList", homeArticlePageSettingList);
		return "manage/freemarker/pagesetting/HomeArticle";
	}
	@RequestMapping("homeArticleCreate")
	public String homeArticleShow(PageSetting pageSetting) {
		pageSetting.setType(PageSettingType.homeArticle.value());
		pageSettingService.insert(pageSetting);
		return "redirect:homeArticle";
	}
	
	@RequestMapping("homeArticleDelete")
	public String homeArticleHide(int id){
		pageSettingService.delete(id);
		return "redirect:homeArticle";
	}
	

	// 首页介绍
	@RequestMapping("homeIntroduction")
	public String homeIntroduction(ModelMap modelMap) {
		List<PageSetting> homeIntroList=pageSettingService.getByType(PageSettingType.homeIntroduction);
		if(!homeIntroList.isEmpty()){
			modelMap.put("title", homeIntroList.get(0).getTitle());
			modelMap.put("homeIntroduction", homeIntroList.get(0).getContent());
		}
		return "manage/freemarker/pagesetting/HomeIntroduction";
	}
	@RequestMapping(value="homeIntroductionUpdate",method=RequestMethod.POST)
	public String homeIntroductionUpdate(PageSetting pageSetting){
		List<PageSetting> homeIntroList=pageSettingService.getByType(PageSettingType.homeIntroduction);
		if(!homeIntroList.isEmpty()){
			PageSetting originalHomeIntro=homeIntroList.get(0);
			originalHomeIntro.setTitle(pageSetting.getTitle());
			originalHomeIntro.setContent(pageSetting.getContent());
			pageSettingService.update(originalHomeIntro);
		}
		else{
			pageSetting.setType(PageSettingType.homeIntroduction.value());
			pageSettingService.insert(pageSetting);
		}
		return "redirect:homeIntroduction";
	}

	// 公司简介
	@RequestMapping("companySummary")
	public String companySummary(ModelMap modelMap) {
		List<PageSetting> homeIntroList=pageSettingService.getByType(PageSettingType.companySummary);
		if(!homeIntroList.isEmpty()){
			modelMap.put("companySummary", homeIntroList.get(0).getContent());
		}
		return "manage/freemarker/pagesetting/CompanySummary";
	}
	@RequestMapping(value="companySummaryUpdate",method=RequestMethod.POST)
	public String companySummaryUpdate(PageSetting pageSetting){
		List<PageSetting> companySummaryList=pageSettingService.getByType(PageSettingType.companySummary);
		if(!companySummaryList.isEmpty()){
			PageSetting originalCompanySummary=companySummaryList.get(0);
			originalCompanySummary.setContent(pageSetting.getContent());
			pageSettingService.update(originalCompanySummary);
		}
		else{
			pageSetting.setType(PageSettingType.companySummary.value());
			pageSettingService.insert(pageSetting);
		}
		return "redirect:companySummary";
	}

}
