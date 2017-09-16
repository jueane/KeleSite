package kele.ui.manage.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kele.entity.SysUser;
import kele.service.SysUserService;

@Controller
@RequestMapping("manage/login")
public class LoginManageController {
	
	@Autowired
	private SysUserService userService;
	
	@RequestMapping
	public String index(){		
		return "manage/freemarker/login/Index";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String index(ModelMap modelMap,SysUser user,HttpSession session){
		if(user.getUsername().isEmpty()||user.getPassword().isEmpty()){
			modelMap.put("notice", "用户名和密码不能为空！");
			return "manage/freemarker/login/Index";
		}
		SysUser userRead=userService.validate(user);
		if(userRead==null){
			modelMap.put("notice", "用户名或密码错误！");
			return "manage/freemarker/login/Index";
		}
		//验证成功
		session.setAttribute("user", userRead);
		return "redirect:/manage/article";
	}

	@RequestMapping("logout")
	public String logout(HttpSession session){
		session.removeAttribute("user");
		return "redirect:";
	}
	
}
