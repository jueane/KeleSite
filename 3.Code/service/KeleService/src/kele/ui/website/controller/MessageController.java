package kele.ui.website.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kele.entity.Message;
import kele.service.MessageService;
import kele.util.Pager;

@Controller
@RequestMapping("message")
public class MessageController {
	
	@Autowired
	private MessageService messageService;
	
	@RequestMapping
	public String index(ModelMap modelMap){
		Pager pager=new Pager();
		messageService.getPagedList(pager);
		modelMap.put("pager", pager);
		return "website/freemarker/message/Index";
	}
	
	@RequestMapping(value="post",method=RequestMethod.POST)
	public String post(Message message){
		messageService.insert(message);
		return "redirect:";
	}
	
	

}
