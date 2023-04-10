package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.BaseClass;

public class NavigationMenuPage {
	
	public NavigationMenuPage() {
		PageFactory.initElements(BaseClass.getDriver(), this);
		
	}
	
	
	@FindBy(xpath="//ul[@class='oxd-main-menu']/li")
	public List<WebElement> NavigationMenu;
	
	
	public void chooseLeftMenuBarOption(String targetMenu) {
		for (WebElement menuOption: NavigationMenu) {
			
			if (menuOption.getText().equalsIgnoreCase(targetMenu)) {
				menuOption.click();
				break;
			}
		}
		
	}
	
	
	
	
	

}
