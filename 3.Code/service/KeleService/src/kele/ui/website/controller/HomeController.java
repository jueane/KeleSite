package kele.ui.website.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import kele.entity.PageSetting;
import kele.service.PageSettingService;
import kele.service.PageSettingService.PageSettingType;

@Controller
@RequestMapping("")
public class HomeController {

	@Autowired
	private PageSettingService pageSettingService;

	@RequestMapping
	public String index(ModelMap modelMap) {
		List<PageSetting> pageSettingList = pageSettingService.getAllList();

		List<PageSetting> homePictureList = new ArrayList<>();
		List<PageSetting> homeArticleList = new ArrayList<>();
		PageSetting homeIntro = null;
		Iterator<PageSetting> iter = pageSettingList.iterator();
		while (iter.hasNext()) {
			PageSetting pageSetting = iter.next();
			if (pageSetting.getType() == PageSettingType.homePicture.value()) {
				homePictureList.add(pageSetting);
			}
			if (pageSetting.getType() == PageSettingType.homeArticle.value()) {
				homeArticleList.add(pageSetting);
			}
			if (pageSetting.getType() == PageSettingType.homeIntroduction.value()) {
				homeIntro = pageSetting;
			}
		}
		modelMap.put("homePictureList", homePictureList);
		modelMap.put("homeArticleList", homeArticleList);
		modelMap.put("homeIntro", homeIntro);

		return "website/freemarker/home/Index";
	}

	@RequestMapping("about")
	public String about(ModelMap modelMap) {
		List<PageSetting> companySummaryList=pageSettingService.getByType(PageSettingType.companySummary);
		if(!companySummaryList.isEmpty()){
			modelMap.put("companySummary", companySummaryList.get(0));
		}
		return "website/freemarker/home/about";
	}

}
