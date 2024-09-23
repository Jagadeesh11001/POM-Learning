package org.servicenow.test;

import org.servicenow.base.servicenowBase;
import org.servicenow.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC001Login extends servicenowBase{

	@BeforeTest
	public void setData() {
		fileName = "TC001Data";
		
	}
	@Test(dataProvider = "data")
	public void loginTest(String[] data) throws InterruptedException {
	
		LoginPage lp = new LoginPage(driver);
		boolean usernameLabel =	lp.userNameLabel();
		Assert.assertTrue(usernameLabel);
		boolean userpassLabel = lp.userPasswordLabel();
		Assert.assertTrue(userpassLabel);
		
		new LoginPage(driver)
		.enterUserName(data[0])
		.enterPassword(data[1])
		.clickLogin();
	}
}
