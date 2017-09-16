package test;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kele.service.SysUserService;

public class Test {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ApplicationContext ctx=new AnnotationConfigApplicationContext(kele.service.impl.SysUserServiceImpl.class);

		SysUserService categoryService=ctx.getBean(kele.service.SysUserService.class);
		


	}

}
