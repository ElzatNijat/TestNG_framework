package testCases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Utilities.BaseClass;
import Utilities.CommonMethods;

public class LoginTestCases extends CommonMethods {
		
	@BeforeMethod
	public void beforeTest() {
		BaseClass.getDriver();
	}
	
	
	@Test(enabled=false)
	public void loginSuccessfully() {
		
//		lp.userTextBox.sendKeys(BaseClass.getProperty("userName"));
//		lp.passwordTextBox.sendKeys(BaseClass.getProperty("passWord"));
//		lp.loginButton.click();
		lp.loginMethod();
		nmp.chooseLeftMenuBarOption(BaseClass.getProperty("admin"));
		
	
//	for (WebElement menuOption: nmp.NavigationMenu) {
//		String saladBar = menuOption.getText();
//		System.out.println(saladBar);
//		
//		if (menuOption.getText().equalsIgnoreCase("admin")) {
//			menuOption.click();
//			break;
//		}
//	}
  }
	
	
	@Test(enabled = false)
	public void testAdminSystemUserSearch() {
		
		lp.loginMethod();
		nmp.chooseLeftMenuBarOption(BaseClass.getProperty("admin"));
		ap.systemUsernameTextBox.sendKeys(BaseClass.getProperty("SystemUsername"));
		ap.userRoleDropDownToExpand.click();
		ap.chooseUserRoleOption(BaseClass.getProperty("SystemRole"));
		
		ap.statusDropDownToExpand.click();
	    ap.chooseUserRoleOption(BaseClass.getProperty("enabled"));
	    ap.searchButton.click();
	    
	    
	    WebDriverWait wait = new WebDriverWait(BaseClass.getDriver(), 30);
	    wait.until(ExpectedConditions.invisibilityOfAllElements(ap.recordsTable.get(0)));
	   
	    System.out.println(ap.recordsTable.size());
	    	
	    Assert.assertTrue(ap.recordsTable.size()==1);
	   
	}	
	
	
	@Test(enabled=false)
	public void addNationality() {
		
		lp.loginMethod();
		nmp.chooseLeftMenuBarOption(BaseClass.getProperty("adminGerman")); // "admin" for english
		ap.ClickAdminTab("Nationaliteiten");  //  ap.ClickAdminTab("Nationalities");
		ap.addNationality("Tibetan");
		
	}
	
	
	
	@Test(enabled=false)
	public void deleteNationality() {
		
		lp.loginMethod();
		nmp.chooseLeftMenuBarOption(BaseClass.getProperty("admin")); // "admin" for english
		ap.ClickAdminTab("Nationalities");  //  ap.ClickAdminTab("Nationalities");
		ap.deleteNationality("Bahamian");
		
	}
	
	
	
	
	
	
	@Test(enabled=false)
	public void randomTesting() {
		
		lp.loginMethod();
		nmp.chooseLeftMenuBarOption(BaseClass.getProperty("admin"));
	
		ap.userRoleDropDownToExpand.click();
		
		List <WebElement> userRoleList = BaseClass.getDriver().findElements(By.xpath("//div[@class='oxd-grid-item oxd-grid-item--gutters'][2]//div[@role='option']"));
		for (WebElement userRoleOption: userRoleList) {
	        if (userRoleOption.getText().equalsIgnoreCase("Admin")) {
	            userRoleOption.click();
	            break;
	        }
			
		}
	
	   
	}	
	
	
	
}
