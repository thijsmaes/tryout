package be.groept.vaadin.model;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;


public class SearchPage extends Template{
	
	List<String> productNames; 
	
	
	public SearchPage(){
		
//		System.out.println(orders.toString());
		
//		productNames = oService.getMatchingProductNamesWithinAllOrders("");
		
//		setContent();
	}
	
	@Override
	public GridLayout setContent() {
		GridLayout gl = new GridLayout(3,50);
		OrderSearchCriteria criteria= new OrderSearchCriteria();
		OrderServiceImpl oService = new OrderServiceImpl();
		List<Order> orders = oService.searchOrders();
		List<Label> labels = new ArrayList<Label>();
		
		int i=0;
		for(Order order:orders){			
						
			for(Product p : order.getProducts()){
				Label nombre = new Label();
				final TextField tf = new TextField();
				Button button = new Button();
				button.addClickListener(new ClickListener(){

					@Override
					public void buttonClick(ClickEvent event) {
						// TODO Auto-generated method stub
						String input = (String) tf.getValue();
						int number = Integer.parseInt(input);
						showOrders(number);
					}

					
					
				});
				System.out.println(p.getProductName());
				nombre.setValue(p.getProductName());
				labels.add(nombre);
				gl.addComponent(nombre, 1, i+1);
				gl.addComponent(tf,2, i+1);
				gl.addComponent(button,3, i+1);
				i++;
			}				
		}
		gl.setSizeFull();
		return gl;
	}	
	
	private GridLayout showOrders(int number) {
		GridLayout gl = new GridLayout();
		
		return content;
		
		
	}
	
	Button button1 = new Button();
}
