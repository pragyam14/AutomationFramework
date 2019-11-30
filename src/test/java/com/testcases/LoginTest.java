package com.testcases;


import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.actions.HomePage;
import com.actions.LoginPage;
import com.base.Page;
import com.relevantcodes.extentreports.LogStatus;


public class LoginTest extends Page {

	@Test
	public void loginTest(){
				
		Page.initConfiguration();
		//test.log(LogStatus.INFO, "Login Test started");
		HomePage home = new HomePage();
		home.gotoSignIn();
		LoginPage login=new LoginPage();
		login.doLogin("username", "password");
		String actual = Page.driver.getTitle();
		String expected="Zero - Account Summary";
		AssertJUnit.assertEquals(actual, expected);
		//test.log(LogStatus.INFO, "Login Test successful");
		Page.quitBrowser();
		}

}
