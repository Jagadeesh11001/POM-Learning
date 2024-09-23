package org.servicenow.test;

import org.servicenow.base.servicenowBase;
import org.servicenow.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC002Login2 extends servicenowBase{

	@Test
	public void loginTest() throws InterruptedException {
	
		LoginPage lp = new LoginPage(driver);
		boolean usernameLabel =	lp.userNameLabel();
		Assert.assertTrue(usernameLabel);
		boolean userpassLabel = lp.userPasswordLabel();
		Assert.assertTrue(userpassLabel);
		
		new LoginPage(driver)
		.enterUserName("admin")
		.enterPassword("cGpt2T!$2RYf")
		.clickLogin();
	}
}
