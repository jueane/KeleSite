package kele.ui.manage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import kele.service.MessageService;
import kele.util.Pager;

@Controller
@RequestMapping("manage/message")
public class MessageManageController {
	
	@Autowired
	private MessageService messageService;
	
	@RequestMapping
	public String index(ModelMap modelMap){
		Pager pager=new Pager();
		messageService.getPagedList(pager);
		modelMap.put("pager", pager);
		return "manage/freemarker/message/Index";
	}
	
	@RequestMapping("delete")
	public String delete(int id){
		messageService.delete(id);
		return "redirect:";
	}
	
	

}
