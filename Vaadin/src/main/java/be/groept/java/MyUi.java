package be.groept.java;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

public class MyUi extends UI{

	@Override
	protected void init(VaadinRequest request) {
		// TODO Auto-generated method stub
		
		
//		Panel panel = new Panel();
//		VerticalLayout vLayout = new VerticalLayout();
//		Button button = new Button("Click me");
//		button.addClickListener(someClickListener());
//		
//		Label label = new Label("This should be a button");
//		
//		vLayout.addComponent(button);
//		vLayout.addComponent(label);
//		panel.add
		
//		setContent(new Ex1View());
//		setContent(new Ex2View());
//		setContent(new Ex3View());
//		setContent(new Ex4View());
//		setContent(new Ex5View());
		setContent(new Ex6View());
	}
	
	private ClickListener someClickListener() {
		// TODO Auto-generated method stub
		return null;
	}

	@WebServlet(value = "/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false,
	ui = MyUi.class)
	public static class Servlet extends VaadinServlet {
	}
}
