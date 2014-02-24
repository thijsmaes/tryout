package be.groept.vaadin.model;

import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;

public class HeaderLayout extends HorizontalLayout {
    
	public HeaderLayout() {
        setWidth("100%");
        setMargin(true);
        setSpacing(true);
        Label label =new Label("dit is een webshop");
        Image image = new Image("/images/webshopSmall.jpg");
        addComponent(label);
        addComponent(image);
    }
    
    
    
}
