package test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class BeansView {
	
	@Bean
	MessageService initMessageService(){
		MessageService msMessageService=new MessageService() {			
			@Override
			public String getMessage() {
				// TODO Auto-generated method stub
				return "ok";
			}
		};
		return msMessageService;
	}
	
	
	
	
}
