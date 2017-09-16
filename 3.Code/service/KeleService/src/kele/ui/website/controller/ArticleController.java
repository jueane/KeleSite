package kele.ui.website.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import kele.service.ArticleService;
import kele.util.Pager;

@Controller
@RequestMapping("article")
public class ArticleController {

	@Autowired
	private ArticleService articleService;

	@RequestMapping
	public String index(ModelMap modelMap, int... page) {
		Pager pager = new Pager();
		if (page != null && page[0] > 1) {
			pager.setPageIndex(page[0]);
		}
		articleService.getPagedList(pager);
		modelMap.addAttribute("pager", pager);
		return "website/freemarker/article/list";
	}
	
	
	@RequestMapping("list")
	public String list(){
		return "website/freemarker/article/List";
	}
	
	
	@RequestMapping("details")
	public String articleDetail(ModelMap modelMap,int id) {
		modelMap.addAttribute("entity",articleService.getById(id));
		return "website/freemarker/article/Details";
	}
}
