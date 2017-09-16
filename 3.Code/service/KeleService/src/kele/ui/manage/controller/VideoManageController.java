package kele.ui.manage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kele.entity.VideoArticle;
import kele.service.VideoArticleService;
import kele.util.Pager;

@Controller
@RequestMapping("manage/video")
public class VideoManageController {
	
	@Autowired
	private VideoArticleService articleService;
	
	@RequestMapping
	public String index(ModelMap modelMap, int... page) {
		Pager pager = new Pager();
		if (page != null && page[0] > 1) {
			pager.setPageIndex(page[0]);
		}
		articleService.getPagedList(pager);
		modelMap.addAttribute("pager", pager);
		return "manage/freemarker/video/Index";
	}
	
	@RequestMapping("create")
	public String create(){
		return "manage/freemarker/video/Create";
	}
	
	@RequestMapping(value = "create", method = RequestMethod.POST)
	public String create(ModelMap modelMap, VideoArticle entity) {
		System.out.println(entity.getTitle());
		System.out.println(entity.getContent());
		articleService.insert(entity);
		//modelMap.addAttribute("notice", "创建成功！" + user.getUsername());
		return "redirect:";
	}
	
	@RequestMapping("edit")
	public String edit(ModelMap modelMap,int id){
		System.out.println("id:"+id);
		VideoArticle entity = articleService.getById(id);
		modelMap.addAttribute("entity", entity);
		
		return "manage/freemarker/video/edit";
	}
	
	@RequestMapping(value="edit",method=RequestMethod.POST)
	@ResponseBody
	public String edit(VideoArticle entity) {
		articleService.update(entity);
		return "redirect:";
	}
	
	@RequestMapping("delete")
	@ResponseBody
	public String delete(int id) {
		VideoArticle entity = articleService.getById(id);
		entity.setDeleted(true);
		articleService.update(entity);
		return "redirect:";
	}

}
