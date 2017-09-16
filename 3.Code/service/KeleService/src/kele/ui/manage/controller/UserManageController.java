package kele.ui.manage.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kele.entity.SysUser;
import kele.service.SysUserService;
import kele.util.Pager;

@Controller
@RequestMapping("manage/user")
public class UserManageController extends BaseController {

	@Autowired
	private SysUserService userService;

	@RequestMapping
	public String index(ModelMap modelMap, int... page) {
		Pager pager = new Pager();
		if (page != null && page[0] > 1) {
			pager.setPageIndex(page[0]);
		}
		userService.getPagedList(pager);
		modelMap.addAttribute("pager", pager);
		return "manage/freemarker/user/Index";
	}

	@RequestMapping("create")
	public String create(ModelMap modelMap, HttpServletRequest request) {
		modelMap.addAttribute("notice", "输入用户名和密码！！");
		return "manage/freemarker/user/Create";
	}

	@RequestMapping(value = "create", method = RequestMethod.POST)
	public String create(ModelMap modelMap, SysUser user) {
		userService.insert(user);
		// modelMap.addAttribute("notice", "创建成功！" + user.getUsername());
		return "redirect:";
	}

	@RequestMapping("passwordChange")
	public String passwordChange(){
		return "manage/freemarker/user/PasswordChange";
	}
	@RequestMapping(value = "passwordChange", method = RequestMethod.POST)
	public String passwordChange(ModelMap modelMap,String pwd,String pwdConfirm,HttpSession session){
		if(pwd.isEmpty()|pwdConfirm.isEmpty()){
			modelMap.put("notice", "密码不能为空！");
			return "manage/freemarker/user/PasswordChange";
		}
		else if(!pwd.equals(pwdConfirm)){
			modelMap.put("notice", "两次输入的密码不一致！");
			return "manage/freemarker/user/PasswordChange";
		}
		else{
			//修改密码
			System.err.println("===========================");
			SysUser user=getUserInfo(session);
			System.err.println(user.getId()+","+user.getUsername());
			SysUser readUser= userService.getById(user.getId());
			readUser.setPassword(pwd);
			userService.update(readUser);
			return "redirect:";
		}
	}
	
	public String edit(ModelMap modelMap, int id) {
		modelMap.put("user", userService.getById(id));
		return "manage/freemarker/user/Edit";
	}
	
	@RequestMapping("delete")
	public String delete(int id){
		userService.delete(id);
		return "redirect:";
	}

}
