package Utilities;

import pages.AdminPage;
import pages.LoginPage;
import pages.NavigationMenuPage;

public class PageInitializer extends BaseClass {

public static LoginPage lp;
public static NavigationMenuPage nmp;
public static AdminPage ap;

	public static void initialize() {

		lp = new LoginPage();
		nmp = new NavigationMenuPage();
		ap = new AdminPage();

	}
	

}
