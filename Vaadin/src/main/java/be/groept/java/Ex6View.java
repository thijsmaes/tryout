package be.groept.java;

import com.vaadin.navigator.Navigator;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

public class Ex6View extends VerticalLayout{
	int counter = 0;
	Button forward = new Button(">");
	Button backward = new Button("<");
	HorizontalLayout hLayout= new HorizontalLayout();
	Label label = new Label();
	
	public Ex6View() {
		label.setValue(Integer.toString(counter));
		hLayout.addComponent(backward);
		hLayout.addComponent(forward);
//		
//		Navigator navigator = new Navigator (this, this);
//		navigator.addView("page1", Ex6page1.Class);
//	Dit moet in MyUI class komen	
/*
 * voor de counter heeft koen gekozen voor een AtomicInteger dus
 * 
 * Label counter = new Label("" + VaadinSession.getCurrent().
 * getAttribute(AtomicInteger.class).getAndIncrement());
 * 
 * hiervoor moet ook iets geschreven worden in de MyUI klasse
 * in de void init(VaadinRequest request){
 * VaadinSession.getCurrent.setAttribute(AtomicInteger.class, new AtomicInteger());
 * er moeten verschillende pagina's geschreven worden voor deze oefening. 
 * de truc is om te werken met de navigator. 
 * 		
 */		
		addComponent(label);
		addComponent(hLayout);
//		addComponent(label2);
		
		forward.addClickListener(new ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				// // TODO Auto-generated method stub
//				String input = textField.getValue();
//				String input2 = textField2.getValue();
//				String input3 = textField3.getValue();
//				String volledig = ("de ingevoerde waarden zijn " + input + ", "
//						+ input2 + ", " + input3);				
//				if(!validateInput(input)){
//					volledig += "...ERROR!!!! eerste textfield meer dan 1 karakter";
//				}
//				label.setValue(volledig);

			}
		});
		
		
	}

}
