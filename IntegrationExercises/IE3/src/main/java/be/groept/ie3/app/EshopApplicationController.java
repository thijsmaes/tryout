package be.groept.ie3.app;

import be.groept.ie3.entities.Eshop;
import be.groept.ie3.screens.LoginScreen;

public class EshopApplicationController {

	// @Autowired
	// private ShopService shopService;

	public void run() {
		String[] usernamePassword = getUsernamePassword();
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

	private String[] getUsernamePassword() {
		return new LoginScreen().drawScreen();
	}

	private Eshop getEshop() {
		// ....
		return null;
	}

	private String showMainScreen() {
		return "";
	}
}