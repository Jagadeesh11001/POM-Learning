package org.servicenow.pages;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.servicenow.base.servicenowBase;

public class LoginPage extends servicenowBase{

	public LoginPage(RemoteWebDriver driver){
		this.driver = driver;
	}
	
	//locators
	public boolean userNameLabel(){
		return driver.findElementByXPath("(//label[@class='control-label'])[1]").isDisplayed();
	}
	
	public boolean userPasswordLabel(){
		return driver.findElementByXPath("//label[@for='user_password']").isDisplayed();
	}
	
	//actions
	/**
	 * @description - to fill the user name field
	 * @param username - user info to be given to login
	 * @return 
	 * @return 
	 */	
	public LoginPage enterUserName(String username){
		
		driver.findElementByXPath("(//input[@class='form-control'])[1]");
		return this;
	}
	
	public LoginPage enterPassword(String password){
		driver.findElementByXPath("//input[@id='user_password']");
		return this;
	}
	
	public dashBoardPage clickLogin() {
		driver.findElementById("sysverb_login").click();
		return new dashBoardPage();
	}
	
	public forgotPasswordPage clickForgotPassword() {
		driver.findElementByLinkText("Forgot Password ?");
		return new forgotPasswordPage();
	}
	/**
	 * @description - the following function is used to login into the servicenow application
	 * @param username
	 * @param password
	 */
	public void login(String username, String password) {
		enterUserName(username);
		enterPassword(password);
		clickLogin();
		
	}

}
