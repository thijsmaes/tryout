package be.groept.vaadin.model;

import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;

public class FooterLayout extends HorizontalLayout{

	public FooterLayout() {
        setWidth("100%");
        setMargin(true);
        setSpacing(true);
        Label label =new Label("copyrighted, do no tre-use without written authorization \"c\"");
        label.setSizeFull();
        addComponent(label);
    }
}
