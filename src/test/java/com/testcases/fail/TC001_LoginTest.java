package com.testcases.fail;


import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
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
		log.debug("Login Test Started.");
		test.log(LogStatus.INFO, "Login Test started");
		
		HomePage home = new HomePage();
		home.gotoSignIn();
		log.debug("Clicked on SignIn Button");
		
		LoginPage login=new LoginPage();
		login.doLogin("username", "password");
		
		String actual = Page.driver.getTitle();
		String expected="Zero - Account Summary";
		AssertJUnit.assertEquals(actual, expected);
		log.debug("Login Test passed successfully.");
		test.log(LogStatus.INFO, "Login Test successful");
		
		Page.quitBrowser();
		}

}


