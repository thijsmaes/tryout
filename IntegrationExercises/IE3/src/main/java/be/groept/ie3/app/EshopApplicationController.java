package be.groept.ie3.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import be.groept.ie3.dao.CustomerDao;
import be.groept.ie3.entities.Customer;
import be.groept.ie3.entities.Eshop;
import be.groept.ie3.screens.LoginScreen;
import be.groept.ie3.service.ShopService;

@Controller
public class EshopApplicationController {

	@Autowired
	private ShopService shopService;
		
	public void run() {
		Customer customer = getCustomer();
		
		if(customer!=null){
			
		}else{
			System.out.println("<i>Error: username or password incorrect</i>");
		}
		Eshop selectedShop = getEshop();

		while (true) {

			String selection = showMainScreen();

			if (selection.equals("1")) {
				// Make orders
			} else if (selection.equals("2")) {
				// List orders
			}
		}
	}

	private Customer getCustomer() {
		String[] usernamePassword = getUsernamePassword();
		String username = usernamePassword[0];
		String password = usernamePassword[1];
		Customer customer = (Customer) shopService.loadCustomer(username);
		if(customer.getPassWord().equals(password)){
			return customer;
		}else{
//			throw new WrongPasswordException();
			return null;
		}		
	}

	private String[] getUsernamePassword() {
		return new LoginScreen().drawScreen();
	}

	private Eshop getEshop() {
		// ....
		return shopService.listEshops().iterator().next();
	}

	private String showMainScreen() {
		return "";
	}
}