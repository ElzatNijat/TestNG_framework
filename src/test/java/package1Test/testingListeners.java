package package1Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners(ListenersTestNG.class)
public class testingListeners {
	
	WebDriver driver;
	
	@Test(priority=1)  // failed test 
	public void openBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		String expectedTitle = "TechCircle School";
		String actual_originalTitle = driver.getTitle();
		
		Assert.assertEquals(actual_originalTitle, expectedTitle);
		
	}
	
	
	@Test(priority=2)  // success test
	public void closeBrowser() {
		driver.close();
		Reporter.log("Driver closed after Testing!");
	}
	

}
