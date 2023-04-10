package testCases;

import Utilities.BaseClass;
import Utilities.CommonMethods;
import pages.LoginPage;

public class testingCommonMethods {
	
	static LoginPage lp;

	public static void main(String[] args) {
		lp = new LoginPage();
		
		CommonMethods.sendText(lp.userTextBox, BaseClass.getProperty("username"));
		
//		CommonMethods.waitForClickability(lp.loginButton);
//		lp.loginButton.click();
		
		CommonMethods.click(lp.loginButton);

	}
	
	

}
