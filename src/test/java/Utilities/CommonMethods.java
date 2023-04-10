package Utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.UnexpectedTagNameException;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonMethods extends PageInitializer {

	// Method that clears and sends key
	public static void sendText(WebElement element, String text) {

		element.clear();
		element.sendKeys(text);
	}

	// methods checks if radio/checkbox is enabled and clicks on it
	public static void clickRadioOrCheckbox(List<WebElement> radioOrCheckbox, String value) {
		String actualValue;
		for (WebElement each : radioOrCheckbox) {
			actualValue = each.getAttribute("value").trim();
			if (actualValue.equals(value)) {
				each.click();
				break;
			}
		}

	}

	// select DropDown value
	public static void selectDropDownValue(WebElement element, String textToBeSelected) {
		try {
			Select select = new Select(element);

			List<WebElement> options = select.getOptions();

			for (WebElement each : options) {

				if (each.getText().equals(textToBeSelected)) {
					select.selectByValue(textToBeSelected);
					break;
				}
			}

		} catch (UnexpectedTagNameException e) {
			e.printStackTrace();
		}

	}

	// select DropDown by index
	public static void selectDropDownIndex(WebElement element, int indexValue) {

		try {
			Select select = new Select(element);

			int size = select.getOptions().size();

			if (size > indexValue) {
				select.selectByIndex(indexValue);
			}

		} catch (UnexpectedTagNameException e) {
			e.printStackTrace();
		}

	}

	// select DropDown by visible text
	public static void selectDropDownVisibleText(WebElement element, String textVisibleToBeSelected) {
		try {
			Select select = new Select(element);

			List<WebElement> options = select.getOptions();

			for (WebElement each : options) {

				if (each.getText().equals(textVisibleToBeSelected)) {
					select.deselectByVisibleText(textVisibleToBeSelected);
					break;
				}
			}

		} catch (UnexpectedTagNameException e) {
			e.printStackTrace();
		}

	}

	// alerts
	public static void dismissAlert() {

		try {
			Alert alert = BaseClass.getDriver().switchTo().alert();

			alert.dismiss();
		} catch (NoAlertPresentException e) {
			e.printStackTrace();
		}
	}
	
	
	//alerts accept
	public static void acceptAlert() {

		try {
			Alert alert = BaseClass.getDriver().switchTo().alert();

			alert.accept();
		} catch (NoAlertPresentException e) {
			e.printStackTrace();
		}
	}
	
	
	//alert get text
	public static String getAlertText() {
		String alertText = null;
		
		try {
			Alert alert = BaseClass.getDriver().switchTo().alert();
			alertText = alert.getText();
		} catch (NoAlertPresentException e) {
			e.printStackTrace();
		}
		return alertText;
	}
	
	
	//alert send text
	public static void alertSendText(String str) {

		try {
			Alert alert = BaseClass.getDriver().switchTo().alert();

			alert.sendKeys(str);
			alert.accept();
		} catch (NoAlertPresentException e) {
			e.printStackTrace();
		}
	}
	
	
	
	//iframe
				//switch using name or id
	public static void switchToFrame(String nameOrId) {
		
		try {
		BaseClass.getDriver().switchTo().frame(nameOrId);
		}catch (NoSuchFrameException e) {
			e.printStackTrace();
		}
	}
	
				//switch using index
	public static void switchToFrame(int index) {
		try {
			BaseClass.getDriver().switchTo().frame(index);
			}catch (NoSuchFrameException e) {
				e.printStackTrace();
			}
		
	}
	
					//switch using web element
	public static void switchToFrame(WebElement element) {
		try {
			BaseClass.getDriver().switchTo().frame(element);
			}catch (NoSuchFrameException e) {
				e.printStackTrace();
			}
	}
	
	
	//handle windows by switching to child window
	public static void switchToChildWindow() {
		
		String mainWindow = BaseClass.getDriver().getWindowHandle();
		Set<String> windows = BaseClass.getDriver().getWindowHandles();
		
		for(String eachWindow: windows) {
			if(!eachWindow.equals(mainWindow)) {
				BaseClass.getDriver().switchTo().window(eachWindow);
			}
		}
	
	}
	
	
	// declaring explicit wait (webdriver) and initiating it and then returning the object
	
	public static WebDriverWait getWaitObject() {
		WebDriverWait wait = new WebDriverWait(BaseClass.getDriver(), 30);
		return wait;
	}
	
	
	//wait for element to be clickable
	public static WebElement waitForClickability(WebElement element) {
		return getWaitObject().until(ExpectedConditions.elementToBeClickable(element));
	}
	
	
	public static WebElement waitForVisibility(WebElement element) {
		return getWaitObject().until(ExpectedConditions.visibilityOf(element));
	}
	
	//wait for the element to be visible then click the element 
	public static void click(WebElement element) {
		waitForVisibility(element).click();
	}
	
	
	//////////////// FUNCTIONS THAT WE DIDN'T GET TO GO OVER
	
    ///// js executer
    // declaring and initializing js object and returning it
    public static JavascriptExecutor getJSObject() {
        JavascriptExecutor js = (JavascriptExecutor) BaseClass.getDriver();
        return js;
    }

    // java script click element
    public static void jsClick(WebElement element) {
        getJSObject().executeScript("arguments[0].click()", element);
    }

    // javascript sends text
    public static void jsSentText(WebElement element, String text) {
        String valueText = element.getAttribute("value");
        getJSObject().executeScript("arguments[0].value='" + valueText + "'", text);
    }

    // scroll to element using js
    public static void scrollToElement(WebElement element) {
        getJSObject().executeScript("arguments[0].scrollIntoView(true);", element);
    }

    // scroll by pixel
    public static void ScrolByPixel(int pixel) {
        // positive -- scroll down
        // negative -- scroll up
        getJSObject().executeScript("window.scrollBy(0," + pixel + ")");
    }

    // getting time stamp
    public static String getTimeStamp() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
        return sdf.format(date.getTime());
    }

    // thread .sleep is simplified
    public static void wait(int seconds) {

        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // hover over == moving your curser on an element
    public static void hover(WebElement element) {
        Actions actions = new Actions(BaseClass.getDriver());
        actions.moveToElement(element).build().perform();
    }

    // create a method that dragsAndDrops
    public static void dragsAndDrops(WebElement element, WebElement element2) {
        Actions action = new Actions(BaseClass.getDriver());
        action.dragAndDrop(element, element2).build().perform();
    }

    // create a method that doubleClicks
    public static void doubleClicks(WebElement element) {
        Actions action = new Actions(BaseClass.getDriver());
        action.doubleClick(element).build().perform();
    }

    // TUESDAY CLASS OVERVIEW
//take screen shot
    public static byte[] takeScreenshot(String filename) {
        TakesScreenshot ts = (TakesScreenshot) BaseClass.getDriver();
        byte[] picBytes = ts.getScreenshotAs(OutputType.BYTES);

        File file = ts.getScreenshotAs(OutputType.FILE);
        String destinationFile = "src/test/resources/screenshots/" + filename + getTimeStamp() + ".png";

        try {
            FileUtils.copyFile(file, new File(destinationFile));
        } catch (Exception ex) {
            System.out.println("Cannot take screenshot!");
        }

        return picBytes;
    }
    
    //
// calendar select date
    public static void selectCalendarDate(List<WebElement> element, String text) {
        for (WebElement pickDate : element) {
            if (pickDate.isEnabled()) {
                if (pickDate.getText().equals(text)) {
                    pickDate.click();
                    break;
                }
            }
        }
    }
    
    
    /**
     * return a list of string from a list of elements ignores any element with no
     * text
     * 
     * @param list
     * @return
     */
    public static List<String> getElementsText(List<WebElement> list) {
        List<String> elemTexts = new ArrayList<String>();
        for (WebElement el : list) {
            if (!el.getText().isEmpty()) {
                elemTexts.add(el.getText());
            }
        }
        return elemTexts;
    }
    
    
    
    public static boolean isDemoMode = true;
    
    //JavaScript Executor the color highlight 
    
    public void highLightElementMethod(WebElement element) {

        try {
            if (isDemoMode) {
                for (int i = 0; i <= 2; i++) {

                    // Create object of a JavascriptExecutor interface
                    JavascriptExecutor js = (JavascriptExecutor) BaseClass.getDriver();
                    // use executeScript() method and pass the arguments
                    // Here i pass values based on css style. Yellow background color with solid red
                    // color border.
                    js.executeScript(
                            "arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');",
                            element);

                    wait(0.2);

                    // Create object of a JavascriptExecutor interface
                    js = (JavascriptExecutor) BaseClass.getDriver();
                    // use executeScript() method and pass the arguments
                    // Here i pass values based on css style. Yellow background color with solid red
                    // color border.
                    js.executeScript(
                            "arguments[0].setAttribute('style', 'background: red; border: 2px solid yellow;');",
                            element);

                    wait(0.2);

                    // Create object of a JavascriptExecutor interface
                    js = (JavascriptExecutor) BaseClass.getDriver();
                    // use executeScript() method and pass the arguments
                    // Here i pass values based on css style. Yellow background color with solid red
                    // color border.
                    js.executeScript("arguments[0].setAttribute('style', 'background: white; border: 2px solid red;');",
                            element);
                }
            }
        } catch (Exception e) {

        }

    }

      
    public void wait(double second) {
        try {
            Thread.sleep((int) (second * 1000));
        } catch (Exception e) {

        }

    }
  

}
