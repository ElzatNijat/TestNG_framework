package BlackTulip_copy;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.BaseClass;
import utilities.CommonMethods;

public class videoGamePageClass {
	public class VideoGamesPage extends CommonMethods {

		public VideoGamesPage() {
			PageFactory.initElements(BaseClass.getDriver(), this);
		}

		@FindBy(xpath = "//a[contains(text(), 'Categories')]")
		public WebElement categoriesDropdown;

		@FindBy(xpath = "//div[@class = 'HeaderModalDropdown']//span[contains(text(), 'Video Games')]")
		public WebElement videoGamesCategory;

		@FindBy(xpath = "//a[contains(text(), 'Explore All')]")
		public WebElement exploreAllButton;

		@FindBy(xpath = "//button[contains(@aria-label, 'navigation items') and contains(text(), 'Show more')]")
		public WebElement showMoreButton;

		@FindBy(xpath = "//a[contains(@data-lnk, 'Video Games New Releases')]")
		public WebElement videoGamesNewReleasesButton;

		@FindBy(xpath = "//button[contains(text(), 'Add to cart')]")
		public List<WebElement> newReleaseVideoGames;

		@FindBy(xpath = "//span[contains(text(), 'Added to cart')]")
		public WebElement addedToCartBox;

		@FindBy(xpath = "//span[contains(text(), 'Digital Downloads')]")
		public WebElement digitalDownloads;

		@FindBy(xpath = "//span[contains(text(), 'All Nintendo Games')]/parent::a")
		public WebElement allNintendoGamesButton;

		@FindBy(xpath = "//div[@class='styles__StyledCol-sc-fw90uk-0 fPNzT']")
		public List<WebElement> digitalVideoGames;

		@FindBy(xpath = "//h3[contains(text(), 'Email delivery')]")
		public WebElement emailDelivery;

		@FindBy(xpath = "//div[contains(text(), 'Download link sent by email after purchase')]")
		public WebElement downloadLink;

		@FindBy(xpath = "//span[contains(@class,'CellSkinny__TextWrapper')]")
		public List<WebElement> categoriesList;

		public void selectCategory(String categoryName) {
			for (int i = 0; i < categoriesList.size(); i++) {
				if (categoriesList.get(i).getText().contains(categoryName)) {
					jsClick(categoriesList.get(i));
					break;
				}
			}
		}

		public void addTheNewGameToCart(String gameTitle) {
			for (int i = 0; i < newReleaseVideoGames.size(); i++) {
				if (newReleaseVideoGames.get(i).getAttribute("aria-label").contains(gameTitle)) {
					jsClick(newReleaseVideoGames.get(i));
					break;
				}
			}
		}

		public void clickTheDigitalGame(String gameTitle) throws InterruptedException {
			for (int i = 0; i < digitalVideoGames.size(); i++) {
				WebElement digitalGame = digitalVideoGames.get(i).findElement(By.xpath("./descendant::div[@title]"));
				if (digitalGame.getAttribute("title").contains(gameTitle)) {
					try {
						digitalGame.click();
					} catch (ElementClickInterceptedException e) {
						Thread.sleep(5000);
						digitalGame.click();
						break;
					}
				}
			}
		}
		
		
		public void goToVideoGames() throws InterruptedException {
			categoriesDropdown.click();
			Thread.sleep(3000);
			
		}
		

	}

}
