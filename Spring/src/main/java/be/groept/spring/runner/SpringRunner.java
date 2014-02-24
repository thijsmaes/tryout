package be.groept.spring.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import be.groept.spring.facade.ServiceFacade;
import be.groept.spring.facade.ServiceFacadeImpl;
import be.groept.spring.repository.OrderRepository;

public class SpringRunner {
	
	private OrderRepository orderRepository;
	
	@Autowired
	private ServiceFacade serviceFacade;
	
	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"/applicationContext.xml");

		//		ServiceFacade serviceFacade = (ServiceFacade) applicationContext.getBean("serviceFacadeImpl");
		
		
		System.out.println("blablabla");
	}
}
