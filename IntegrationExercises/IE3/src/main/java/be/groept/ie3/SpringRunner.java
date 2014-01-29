package be.groept.ie3;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import be.groept.ie3.app.EshopApplicationController;

public class SpringRunner {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"/applicationContext.xml");

		EshopApplicationController controller = (EshopApplicationController) applicationContext
				.getBean("eshopApplicationController");
		controller.run();

		applicationContext.close();
	}
}
