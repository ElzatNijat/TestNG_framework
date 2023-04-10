package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import Utilities.BaseClass;

public class LoginPage {
	
	public LoginPage() {
		PageFactory.initElements(BaseClass.getDriver(), this);
		
	}
	
	@FindBy(name="username")
	public WebElement userTextBox;
	
	@FindBy(name="password")
	public WebElement passwordTextBox;
	
	@FindBy(xpath="//button[contains(@class, 'login-button')]")
	public WebElement loginButton;
	
	
	@Test
	public void loginMethod() {
		userTextBox.sendKeys(BaseClass.getProperty("userName"));
		passwordTextBox.sendKeys(BaseClass.getProperty("passWord"));
		loginButton.click();
	}
	
	
}
