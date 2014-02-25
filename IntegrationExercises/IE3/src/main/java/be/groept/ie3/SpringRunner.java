package be.groept.ie3;

import org.hibernate.SessionFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.support.TransactionTemplate;

import be.groept.ie3.app.EshopApplicationController;
import be.groept.util.InitialDataSetup;

public class SpringRunner {

	
	private static InitialDataSetup init;
	
	public static void main(String[] args) {
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"/applicationContext.xml");


		
		EshopApplicationController controller = (EshopApplicationController) applicationContext
				.getBean("eshopApplicationController");
		controller.run();

		applicationContext.close();
	}
}
