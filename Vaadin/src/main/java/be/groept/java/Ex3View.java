package be.groept.java;

import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.VerticalLayout;

public class Ex3View extends HorizontalLayout {

	private int counter = 0;
	private Button button1 = new Button();
	private Button button2 = new Button();
	private Button button3 = new Button();
	private Button button4 = new Button("Update everything");

	Label label1 = new Label();
	Label label2 = new Label();
	Label label3 = new Label();

	public Ex3View() {
		HorizontalLayout h1Lay = new HorizontalLayout();
		HorizontalLayout h2Lay = new HorizontalLayout();
		HorizontalLayout h3Lay = new HorizontalLayout();
		VerticalLayout vLay = new VerticalLayout();

		h1Lay.addComponent(button1);
		h1Lay.addComponent(label1);
		button1.addClickListener(new ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				// TODO Auto-generated method stub
				increment();
				label1.setValue(String.valueOf(counter));
			}
		});

		h2Lay.addComponent(button2);
		h2Lay.addComponent(label2);
		button2.addClickListener(new ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				// TODO Auto-generated method stub
				increment();
				label2.setValue(String.valueOf(counter));
			}
		});

		h3Lay.addComponent(button3);
		h3Lay.addComponent(label3);
		button3.addClickListener(new ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				// TODO Auto-generated method stub
				increment();
				label3.setValue(String.valueOf(counter));
			}
		});
		
		button4.addClickListener(new ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				// TODO Auto-generated method stub
				label1.setValue(String.valueOf(counter));
				label2.setValue(String.valueOf(counter));
				label3.setValue(String.valueOf(counter));
			}
		});
		
		vLay.addComponent(h1Lay);
		vLay.addComponent(h2Lay);
		vLay.addComponent(h3Lay);
		vLay.addComponent(button4);
		
		addComponent(vLay);
	}

	public int getCounter() {
		return counter;
	}

	public void increment() {
		counter++;
	}

}
