package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.BaseClass;

public class AdminPage {
	
	public AdminPage() {
		PageFactory.initElements(BaseClass.getDriver(), this);
	}
	
	
	@FindBy(xpath="//div[@class='oxd-table-filter']//input[@class='oxd-input oxd-input--active']")
	public WebElement systemUsernameTextBox;
	
	@FindBy(xpath="//div[@class='oxd-grid-4 orangehrm-full-width-grid']/div[2]/div/div[2]/div/div")
    public WebElement userRoleDropDownToExpand;
	
    @FindBy(xpath="//div[@class='oxd-grid-4 orangehrm-full-width-grid']/div[4]/div/div[2]/div/div")
    public WebElement statusDropDownToExpand;
	
    @FindBy(xpath="//button[@type='submit']")
    public WebElement searchButton;
    
    
	@FindBy(xpath="//div[@class='oxd-select-dropdown --positon-bottom']/div")
	public List<WebElement> userRoleDropDownOptions;
	
	public void chooseUserRoleOption(String menuValue) {
	for (WebElement userRoleOption: userRoleDropDownOptions) {
        if (userRoleOption.getText().equalsIgnoreCase(menuValue)) {
            userRoleOption.click();
            break;
        }
		
	}
	
	}
	

	@FindBy(xpath="//div[@class='oxd-table-body']/div")
	 public List<WebElement> recordsTable;
	
	
	@FindBy(xpath="//li[contains(@class, 'oxd-topbar-body-nav-tab')]")
	public List<WebElement> adminTabs;
	
	
	public void ClickAdminTab(String targetTab) {
		
		for (WebElement eachTab: adminTabs) {			
			if (eachTab.getText().contains(targetTab)) {
				eachTab.click();
				break;
			}
			
		}
	}
	
	
	
	 @FindBy(xpath="//button[contains(@class, 'page-item--previous-next')]//i[@class='oxd-icon bi-chevron-right']")
	  public WebElement nextPageButton;
	
	 @FindBy(xpath="//button[@class='oxd-button oxd-button--medium oxd-button--secondary']")
	  public WebElement addButton;
	
	@FindBy(xpath="//div[@class='oxd-table-card']")
	 public List<WebElement> nationalitiesEachPage;
	
    @FindBy(xpath="//ul[@class='oxd-pagination__ul']/li//button[@class='oxd-pagination-page-item oxd-pagination-page-item--page']")
	 public List<WebElement> pages;
	
    
	
     public void addNationality(String targetNationality) {
    	 
    	 boolean targetFound = false;
    	 
    	 outer:
    	 for (int i = 0; i <= pages.size(); i++) {
    		 
    		 if (i!=0) nextPageButton.click();
    		 
    		 for (WebElement each: nationalitiesEachPage) {		
    				if (each.getText().contains(targetNationality)) {
    					System.out.println(each.getText());
    					targetFound = true;
    					break outer;
    				} 
    	      }
    		 
    	 }
    	 
    	 if (targetFound == false) {
    		     		 
    		JavascriptExecutor js1 = (JavascriptExecutor) BaseClass.getDriver();
    	    js1.executeScript("arguments[0].click();", addButton);
    		 	 
    		 WebElement addNationalityName = BaseClass.getDriver().findElement(By.xpath("//div[@class='orangehrm-card-container']//input[@class='oxd-input oxd-input--active']"));
    		 addNationalityName.sendKeys(targetNationality);
    		 
    		 WebElement saveButton = BaseClass.getDriver().findElement(By.xpath("//button[@type='submit']"));
    		 saveButton.click();
    	 }
    	 
	
     }
     
     
     
     
  public void deleteNationality(String targetNationality) {
    	 
    	 boolean targetFound = false;
    	 
    	 outer:
    	 for (int i = 0; i <= pages.size(); i++) {
    		 
    		 if (i!=0) nextPageButton.click();
    		 
    		 for (WebElement each: nationalitiesEachPage) {		
    				if (each.getText().contains(targetNationality)) {
    					System.out.println(each.getText());
    					each.findElement(By.xpath("//i[@class='oxd-icon bi-trash']")).click();
    					BaseClass.getDriver().findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--label-danger orangehrm-button-margin']")).click();
    					break outer;
    				} 
    	      }
    		 
    	 }
    	 	 
	
     }
     
     
     
     
     
     
     
     

}
