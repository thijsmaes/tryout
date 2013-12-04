package be.groept.java;

import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;



public class Ex1View extends HorizontalLayout {
	Button button = new Button("Click me");
//	String text = "";
//	Label label = new Label(text);
	Label label = new Label("Hello World!");
//	label.setVisible(false);
	
	
	public Ex1View(){
		this.addComponent(button);
		this.addComponent(label);
//		label.setVisible(false);
		
		button.addClickListener(new ClickListener(){
			
			@Override
			public void buttonClick(ClickEvent event) {
				label.setVisible(!label.isVisible());
				
				// TODO Auto-generated method stub
//				if (text.equals("")){
//				text = "Hello world!";
//				}
//				else if(text.equals("Hello world!")){
//					text ="";
//				}
//				else{
//					System.err.println("there is something heavily wrong");
//				}
				}
			});
			
		};
	}


