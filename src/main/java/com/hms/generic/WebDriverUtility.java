package com.hms.generic;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {

	/**
	 * This method is used to launch browser.
	 * 
	 * @param driver
	 * @param Browsername
	 * @return WebDriver driver
	 */
	public WebDriver browserLaunch(WebDriver driver, String Browsername) {
		if (Browsername.equalsIgnoreCase("chrome"))
			driver = new ChromeDriver();
		else if (Browsername.equalsIgnoreCase("firefox"))
			driver = new FirefoxDriver();
		else if (Browsername.equalsIgnoreCase("safari"))
			driver = new SafariDriver();
		else if (Browsername.equalsIgnoreCase("microsoftedge"))
			driver = new EdgeDriver();
		
		return driver;
	}

	/**
	 * This method is used to maximize the browser.
	 * 
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}

	/**
	 * This method is used to implicitly wait for elements untill pageload.
	 * 
	 * @param driver
	 */
	public void waitForPagetoLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	/**
	 * This method is used to explicitly wait for elements untill pageload.
	 * 
	 * @param driver
	 * @param element
	 */
	public void elementToBeVisible(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	/**
	 * This method is used to handle list box by index.
	 * 
	 * @param element
	 * @param index
	 */
	public void select(WebElement element, int index) {
		Select s = new Select(element);
		s.selectByIndex(index);
	}

	/**
	 * This method is used to handle list box by visibletext.
	 * 
	 * @param element
	 * @param visibletxt
	 */
	public void select(WebElement element, String visibletxt) {
		Select s = new Select(element);
		s.selectByVisibleText(visibletxt);
	}

	/**
	 * This method is used move the mouse to required element.
	 * 
	 * @param element
	 * @param driver
	 */

	public void mouseHover(WebElement element, WebDriver driver) {
		Actions a = new Actions(driver);
		a.moveToElement(element).perform();
	}

	/**
	 * This method is used to perform right click on required element .
	 * 
	 * @param element
	 * @param driver
	 */
	public void rightclick(WebElement element, WebDriver driver) {
		Actions a = new Actions(driver);
		a.contextClick(element).perform();
	}

	/**
	 * This method is used to perform right click anywhere on webpage.
	 * 
	 * @param driver
	 */
	public void rightclick(WebDriver driver) {
		Actions a = new Actions(driver);
		a.contextClick().perform();
	}

	/**
	 * This method is used to perform doubleclick on required element .
	 * 
	 * @param element
	 * @param driver
	 */
	public void doubleclick(WebElement element, WebDriver driver) {
		Actions a = new Actions(driver);
		a.doubleClick(element).perform();
		;
	}

	/**
	 * This method is used to perform doubleclick anywhere on webpage.
	 * 
	 * @param driver
	 */
	public void mouseHover(WebDriver driver) {
		Actions a = new Actions(driver);
		a.doubleClick().perform();
	}

	/**
	 * This method is used to perform drag and drop actions.
	 * 
	 * @param target
	 * @param source
	 * @param driver
	 */
	public void dragAndDrop(WebElement target, WebElement source, WebDriver driver) {
		Actions a = new Actions(driver);
		a.dragAndDrop(source, target).perform();
	}

	/**
	 * This method is used to press enter button by using keys class.
	 * 
	 * @param driver
	 * @throws AWTException 
	 */
	public void pressEnterAction(WebDriver driver) throws AWTException {
		Actions a = new Actions(driver);
		a.sendKeys(Keys.ENTER).perform();
	}

	/**
	 * This method is used to press Enter button by using Robot class.
	 * 
	 * @throws AWTException
	 */
	public void pressEnterRobot() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
	}

	/**
	 * This method is used to relaese Enter Key by using Robot class.
	 * 
	 * @param driver
	 * @throws AWTException
	 */
	public void relaeseEnterKey(WebDriver driver) throws AWTException {
		Robot r = new Robot();
		r.keyRelease(KeyEvent.VK_ENTER);
	}

	/**
	 * This method is used to Switch into Frame by using Index.
	 * 
	 * @param driver
	 * @param index
	 */
	public void switchToFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}

	/**
	 * This method is used to Switch into Frame by using name or Id.
	 * 
	 * @param driver
	 * @param nameOrId
	 */
	public void switchToFrame(WebDriver driver, String nameOrId) {
		driver.switchTo().frame(nameOrId);
	}

	/**
	 * This method is used to Switch into Frame by using element.
	 * 
	 * @param driver
	 * @param element
	 */
	public void switchToFrame(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
	}

	/**
	 * This method is used to handle alert popup by clcking Ok button.
	 * 
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver) {
		try {
			driver.switchTo().alert().accept();	
		}
	catch (Exception e) {
		System.out.println("alert not present");
	}
	}

	/**
	 * This method is used to handle alert popup by clcking cancel button.
	 * 
	 * @param driver
	 */
	public void dismissAlert(WebDriver driver) {
		try {
			driver.switchTo().alert().dismiss();
		} catch (Exception e) {
			System.out.println("alert not present");
		}
	}

	/**
	 * This method is used to get Text present in alert popup.
	 * 
	 * @param driver
	 * @return
	 */
	public String getAlertText(WebDriver driver) {
		String text="alert not present";
		try {
			 text = driver.switchTo().alert().getText();

		} catch (Exception e) {
			
		}
		return text;
	}

	/**
	 * This method is used to Switch into required window by using Pagetitle.
	 * 
	 * @param driver
	 * @param eTitle
	 */
	public void switchToWindow(WebDriver driver, String eTitle) {
		Set<String> wh = driver.getWindowHandles();
		Iterator<String> itr = wh.iterator();
		while (itr.hasNext()) {
			driver.switchTo().window(itr.next());
			String title = driver.getTitle();
			if (title.contains(eTitle))
				break;
		}

	}

	/**
	 * This method is used to take screenshot
	 * 
	 * @param driver
	 * @param screenShotName
	 * @throws IOException
	 */
	public void screenShot(WebDriver driver, String screenShotName) throws IOException {
		TakesScreenshot s = (TakesScreenshot) driver;
		File src = s.getScreenshotAs(OutputType.FILE);
		File desc = new File("./screenshots/" + screenShotName + ".png");
		FileUtils.copyFile(src, desc);

	}

	/**
	 * This method is used to scroll randomly in webpage.
	 * 
	 * @param driver
	 */
	public void scrollBarAction(WebDriver driver) {
		JavascriptExecutor j = (JavascriptExecutor) driver;
		j.executeScript("window.scrollby(0,800)");
	}

	/**
	 * This method is used to scroll to particular element.
	 * 
	 * @param driver
	 * @param element
	 */
	public void scrollBarAction(WebDriver driver, WebElement element) {
		JavascriptExecutor j = (JavascriptExecutor) driver;
		int y = element.getLocation().getY();
		j.executeScript("window.scrollby(0," + y + ")");
	}

	/**
	 * This method is used to wait untill Element To be Clickable.
	 * 
	 * @param driver
	 * @param element
	 */

	public void waitForElementTobeClickable(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

}
