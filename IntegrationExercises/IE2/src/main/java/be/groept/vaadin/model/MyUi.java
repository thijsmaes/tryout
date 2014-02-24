package be.groept.vaadin.model;

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
		setContent(new SearchPage());
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
