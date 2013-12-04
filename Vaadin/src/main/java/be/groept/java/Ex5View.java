package be.groept.java;

import com.vaadin.data.Validator;
import com.vaadin.data.validator.StringLengthValidator;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

public class Ex5View extends HorizontalLayout {
	TextField textField = new TextField();
	TextField textField2 = new TextField();
	TextField textField3 = new TextField();
	VerticalLayout vLayout = new VerticalLayout();
	HorizontalLayout hLayout = new HorizontalLayout();
	HorizontalLayout hLayout2 = new HorizontalLayout();
	Button submit = new Button();
	Button clear = new Button();
	Label label = new Label();

	public Ex5View() {
		textField.setNullRepresentation(null);
		textField2.setNullRepresentation(null);
		textField3.setNullRepresentation(null);
		hLayout.addComponent(textField);
		hLayout.addComponent(textField2);
		hLayout.addComponent(textField3);
		hLayout.addComponent(label);
		hLayout2.addComponent(submit);
		hLayout2.addComponent(clear);
		vLayout.addComponent(hLayout);
		vLayout.addComponent(hLayout2);
		addComponent(vLayout);

		String input = textField.getValue();
		String input2 = textField2.getValue();
		String input3 = textField3.getValue();

		submit.addClickListener(new ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				// // TODO Auto-generated method stub
				String input = textField.getValue();
				String input2 = textField2.getValue();
				String input3 = textField3.getValue();
				String volledig = ("de ingevoerde waarden zijn " + input + ", "
						+ input2 + ", " + input3);				
				if(!validateInput(input)){
					volledig += "...ERROR!!!! eerste textfield meer dan 1 karakter";
				}
				label.setValue(volledig);

			}
		});
		textField.addValidator(new StringLengthValidator("Entry should be 1 char", 1, 1, true));
		
		clear.addClickListener(new ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				// // TODO Auto-generated method stub
				String input = "";
				String input2 = "";
				String input3 = "";
				// String volledig = ("de ingevoerde waarden zijn " + input+
				// ", " +input2+", "+input3);
				label.setValue("");
				addComponent(label);
				textField.setValue(input);
				textField2.setValue(input2);
				textField3.setValue(input3);
			}
		});
	}
	
	public boolean validateInput(String input){
		if(input.length() > 1){
			return false;
		}else{
			return true;
		}
	}

}
