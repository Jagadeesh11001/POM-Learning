package org.servicenow.base;

import org.openqa.selenium.WebElement;

public interface BaseInterface {

	//Setup, Close, Element, Alert, Frames, WindowHandling, Select
	//Click, Type, Page related verification, element related verification
	
	/**
	 * This will launch the chrome browser with the given URL
	 * @author jagan  
	 * @param URL
	 * @exception NullPointerException, InvalidArgumentException
	 */
	
	// TODO: 
	void setUp(String URL);
	
	/**
	 * This method will launch the given browser with the given URL
	 * @author jagan
	 * @param browserName
	 * @param URL
	 */
	void setUp(Browser browserName,String URL);
	
	/**
	 * This function is used to close the active browser
	 * @author jagan 
	 */
	void close();
	
	/**
	 * This function is used to quit the active browser
	 * @author jagan 
	 */
	void quit();
	
	
	/**
	 * This method help finding any element within the page
	 * @param type - element type eg - id, class,xpath...
	 * @param value - element value
	 * @return WebElement
	 */
	WebElement element(String type, String value);
	
	/**
	 * This method is used to switch to a specific tab
	 * @author jagan
	 * @param i 
	 */
	void switchToWindow(int i);
	
	/**
	 * This method is used to select the dropdown within the given value
	 * @author jagan
	 * @param ele
	 * @param value
	 */
	void selectValue(WebElement ele, String value);
	
	/**
	 * This method is used to select dropdown within the given text
	 * @param ele
	 * @param text
	 */
	void selectText(WebElement ele, String text);
	
	/**
	 * This method is used to select dropdown within the given index
	 * @author jagan
	 * @param ele
	 * @param index
	 */
	void selectIndex(WebElement ele, int index);
	
	/**
	 * This function will wait until the element is clickable and then click
	 * @author jagan
	 * @param ele
	 */
	void click(WebElement ele);
	
	/**
	 * This function will wait until the element is ready and clear the existing value and type
	 * @author jagan
	 * @param ele
	 */
	void type(WebElement ele, String testData);
	
	/**
	 * This function will wait until the element is ready and gets the input
	 * @author jagan
	 * @param ele
	 */
	void appendText(WebElement ele, String testData);
	
	/**
	 * This functions returns the active page title	 
	 * @author jagan
	 * @return
	 */
	String getTitle();
	
	/**
	 * This function returns the active page url
	 * @author jagan
	 * @return
	 */
	String getURL();
	
	/**
	 * This function returns if the element is visible or not
	 * @author jagan
	 * @return
	 */
	boolean isDisplayed();
	
	/**
	 * This function returns if the element is enabled or not
	 * @return
	 */
	boolean isEnabled();

	boolean isDisplayed(WebElement ele);
	
	
	
}
