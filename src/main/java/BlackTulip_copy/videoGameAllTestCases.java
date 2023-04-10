package BlackTulip_copy;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import utilities.CommonMethods;
import utilities.RetryAnalyzer;

public class videoGameAllTestCases {
	
	public class VideoGames_AllTestCases extends CommonMethods {
		  
		@Test(priority = 1, retryAnalyzer= RetryAnalyzer.class)
		public void testNewReleaseVideoGames() throws InterruptedException {
			vg.goToVideoGames();
			vg.selectCategory(getProperty("videoGames"));
		//	vg.selectCategory("Video Games"); 
			vg.exploreAllButton.click();
			vg.showMoreButton.click();
			vg.videoGamesNewReleasesButton.click();		
			getWaitObject().until(ExpectedConditions.urlContains("new-releases"));
			assertEqualsTitle("New Video Game Releases");		
		}
		
		
		@Test(priority = 2, retryAnalyzer= RetryAnalyzer.class)
		public void testAddVideoGameToCart() throws InterruptedException {
			vg.goToVideoGames();
			vg.selectCategory(getProperty("videoGames"));
			vg.exploreAllButton.click();
			vg.showMoreButton.click();
			vg.videoGamesNewReleasesButton.click();	
			vg.addTheNewGameToCart("Nintendo Switch Mario Choose One Bundle");
			getWaitObject().until(ExpectedConditions.visibilityOf(vg.addedToCartBox));
			Assert.assertTrue(vg.addedToCartBox.isDisplayed(), "'Added to cart' is not disaplyed");
			
		}
		
		@Test(priority = 3, retryAnalyzer= RetryAnalyzer.class)
		public void testDigitalDownloadVideoGame() throws InterruptedException {
			
			vg.categoriesDropdown.click();
			vg.selectCategory(getProperty("videoGames"));
			vg.digitalDownloads.click();
			jsClick(vg.allNintendoGamesButton);
		    vg.clickTheDigitalGame("Stardew Valley");
		    Assert.assertTrue(vg.emailDelivery.isDisplayed(), "'Email delivery' is not disaplyed");
			
		}
		


}
