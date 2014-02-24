package be.groept.vaadin.model;

import com.vaadin.ui.GridLayout;
import com.vaadin.ui.VerticalLayout;

public class Template extends VerticalLayout{
	HeaderLayout header;
	FooterLayout footer;
	GridLayout content;
	
	public Template(){
		buildComps();

		addComponent(header);
		addComponent(content);
		addComponent(footer);
	}

	private void buildComps() {
		header = new HeaderLayout();
		footer= new FooterLayout();
		content = setContent();
		
		header.setHeight("60px");
		footer.setHeight("60px");
		content.setHeight("600px");
		
	}

	public GridLayout setContent() {
		return new GridLayout();
	}
}
