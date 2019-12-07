package com.testcases;


import org.testng.annotations.Test;
import org.testng.Assert;
import com.actions.HomePage;
import com.actions.LoginPage;
import com.base.Page;
import com.relevantcodes.extentreports.LogStatus;


public class TC001_LoginTest extends Page {

	
	@Test(priority = 1)
	public void loginTest(){
				
		Page.initConfiguration();
		
		HomePage home = new HomePage();
		home.gotoSignIn();
		log.info("Clicked on SignIn Button");
		
		LoginPage login=new LoginPage();
		login.doLogin("username", "password");
		log.debug("Login Test Started");
		test.log(LogStatus.INFO, "Login Test started");
		
		String actual = Page.driver.getTitle();
		String expected="Zero - Account Summary";
		Assert.assertEquals(actual, expected);
		log.info("Login Test passed successfully.");
		test.log(LogStatus.INFO, "Logged into Zero Banking successfully");
		
		Page.quitBrowser();
		}

}


