package be.groept.java;

import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;

public class Ex2View extends HorizontalLayout{
	Button button = new Button("Click me to read textfield");
	TextField textField = new TextField();
	String input="";
	Label label = new Label();
	
	public Ex2View(){
		textField.setNullRepresentation(null);
		
		addComponent(button);
	addComponent(textField);
//	textField.setValue("testing");
	textField.setConverter(Integer.class);	
	textField.setImmediate(true);
	
//	textField.addValueChangeListener(new ValueChangeListener() {
//		
//		@Override
//		public void valueChange(ValueChangeEvent event) {
//			// TODO Auto-generated method stub
//			input = textField.getValue();
//			if(textField.isValid()){
//				label.setValue(input);	
//			}else{
//				label.setValue("numerische waarde moet ingevoerd worden");
//			}
//			
//			addComponent(label);
//		}
//	});
//	
//	
	
	button.addClickListener(new ClickListener(){

		@Override
		public void buttonClick(ClickEvent event) {
//			// TODO Auto-generated method stub
			input = textField.getValue();
			if(textField.isValid()){
				label.setValue(input);	
			}else{
				label.setValue("numerische waarde moet ingevoerd worden");
			}
			
			addComponent(label);			
	}
	});
	if(textField.isValid()){
		label.setValue(input);	
	}else{
		label.setValue("numerische waarde moet ingevoerd worden");
	}
	addComponent(label);
	
}
}
