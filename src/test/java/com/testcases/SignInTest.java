package com.testcases;

import org.testng.annotations.Test;

import com.actions.HomePage;
import com.base.Page;


public class SignInTest extends Page {


	@Test
	public void signInTest() {

		Page.initConfiguration();
		//test.log(LogStatus.INFO, "SignIn Test started");
		HomePage home=new HomePage();
		home.gotoSignIn();
		System.out.println("firt test: Signin test started");
		//test.log(LogStatus.INFO, "SignIn Test ended");
		Page.quitBrowser();	

	}

}
  