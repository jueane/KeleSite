package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class MyTest {

	public static void main(String args[]){
		ApplicationContext ctx=new AnnotationConfigApplicationContext(BeansView.class);		
		
		MessagePrinter printer=ctx.getBean(MessagePrinter.class);
		
		printer.printMessage();
				
	
	}
	

}