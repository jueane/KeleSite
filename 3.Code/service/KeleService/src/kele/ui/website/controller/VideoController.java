package kele.ui.website.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import kele.entity.VideoArticle;
import kele.service.VideoArticleService;
import kele.util.Pager;

@Controller
@RequestMapping("video")
public class VideoController {

	@Autowired
	private VideoArticleService articleService;
//http://player.youku.com/player.php/sid/XNTkxOTc4ODI4/v.swf
	@RequestMapping
	public String index(ModelMap modelMap, int... page) {
		Pager pager = new Pager();
		if (page != null && page[0] > 1) {
			pager.setPageIndex(page[0]);
		}
		articleService.getPagedList(pager);
		modelMap.addAttribute("pager", pager);
		return "website/freemarker/video/list";
	}
	
	
	@RequestMapping("list")
	public String list(){
		return "website/freemarker/video/List";
	}
	
	
	@RequestMapping("details")
	public String articleDetail(ModelMap modelMap,int id) {
		System.out.println("------id:"+id);
		VideoArticle entity = articleService.getById(id);
		modelMap.addAttribute("entity", entity);
		return "website/freemarker/video/Details";
	}
}
