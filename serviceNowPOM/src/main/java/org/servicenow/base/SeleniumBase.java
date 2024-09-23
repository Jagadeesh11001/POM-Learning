package org.servicenow.base;

import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.formula.atp.Switch;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByLinkText;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.internal.ExpectedExceptionsHolder;

public class SeleniumBase implements BaseInterface{

	long timeOut = 30;
	long maxWaitTime = 10;
	
	WebDriverWait wait = null;
	RemoteWebDriver driver = null;
	
	@Override
	public void setUp(String URL) {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
		driver.get(URL);
		wait = new WebDriverWait(driver, maxWaitTime);
	}

	@Override
	public void setUp(Browser browserName, String URL) {
		switch (browserName) {
		case CHROME:
			driver = new ChromeDriver();
			break;
		case FIREFOX:
			driver = new FirefoxDriver();
			break;
		default:
			System.err.println("driver is not defined");
			break;
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
		driver.get(URL);
		wait = new WebDriverWait(driver, maxWaitTime);

	}

	@Override
	public void close() {
		driver.close();
		
	}

	@Override
	public void quit() {
		driver.quit();
		
	}

	@Override
	public WebElement element(String type, String value) {
		switch (type) {
		case "id":
			return driver.findElement(By.id(value));
		case "name":
			return driver.findElement(By.name(value));
		case "xpath":
			return driver.findElement(By.xpath(value));
		case "link":
			return driver.findElement(By.linkText(value));
		

		default:
			break;
		}
		return null;
	}

	@Override
	public void switchToWindow(int i) {
		Set<String> windowHandles = driver.getWindowHandles();
		ArrayList<String> list = new ArrayList<String>(windowHandles);
		driver.switchTo().window(list.get(i));
		
	}

	@Override
	public void selectValue(WebElement ele, String value) {
		WebElement element = isElementVisible(ele);
		new Select(element).selectByValue(value);
	}

	@Override
	public void selectText(WebElement ele, String text) {
		WebElement element = isElementVisible(ele);
		new Select(element).selectByVisibleText(text);
	}

	@Override
	public void selectIndex(WebElement ele, int index) {
		WebElement element = isElementVisible(ele);
		new Select(element).selectByIndex(index);
	}

	@Override
	public void click(WebElement ele) {
		WebElement element = isElementVisible(ele);
		element.click();
		
	}

	private WebElement isElementVisible(WebElement ele) {
		WebElement element = wait.withMessage("element is not visible").
				until(ExpectedConditions.elementToBeClickable(ele));
		return element;
	}

	@Override
	public void type(WebElement ele, String testData) {
		WebElement element = wait.until(ExpectedConditions.visibilityOf(ele));
		element.clear();
		element.sendKeys(testData);
	}
	
	public void type(WebElement ele, String testData, Keys keys) {
		WebElement element = wait.until(ExpectedConditions.visibilityOf(ele));
		element.clear();
		element.sendKeys(testData, keys);
	}

	@Override
	public void appendText(WebElement ele, String testData) {
		WebElement element = wait.until(ExpectedConditions.visibilityOf(ele));
		element.sendKeys(testData);
	}

	@Override
	public String getTitle() {
		return driver.getTitle();
	}

	@Override
	public String getURL() {
		return driver.getCurrentUrl();
	}

	@Override
	public boolean isDisplayed(WebElement ele) {
		return ele.isDisplayed();
	}
 
	@Override
	public boolean isEnabled() {
		return false;
	}

	@Override
	public boolean isDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}

}
