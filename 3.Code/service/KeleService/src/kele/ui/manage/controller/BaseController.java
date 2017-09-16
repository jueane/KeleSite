package kele.ui.manage.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import kele.entity.SysUser;

public abstract class BaseController {
	
	protected SysUser getUserInfo(HttpSession session) {
		SysUser user=null;
		if (session != null) {
			user = (SysUser) session.getAttribute("user");
		}
		return user;
	}

}
