package com.testcases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.actions.AccountSummaryPage;
import com.actions.HomePage;
import com.actions.LoginPage;
import com.actions.PayBillsPage;
import com.base.Page;
import com.locators.PayBillsLocators;

public class TC002_PaySavedPayee extends Page {

	
	@Test(priority = 2)
	public void PaySavedPayee() {
		Page.initConfiguration();
		log.debug("Login Test Started.");
		//test.log(LogStatus.INFO, "Login Test started");
		
		HomePage home = new HomePage();
		home.gotoSignIn();
		log.debug("Clicked on SignIn Button");
		
		LoginPage login=new LoginPage();
		login.doLogin("username", "password");
		
		AccountSummaryPage asp = new AccountSummaryPage();
		asp.goToPayBills();
		log.debug("clicked to Paybills tab");
		
		PayBillsPage pb = new PayBillsPage();
		pb.SelectPayee().selectByValue("apple");
		pb.SelectAccount().selectByValue("2");
		pb.PayPayee("500", "2017-12-22", "Tution Fee");
		
		PayBillsLocators locator = new PayBillsLocators();
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 10);
		PageFactory.initElements(factory, locator);

		String Actualmsg = locator.SuccessMsg.getText();
		String Expectedmsg = "The payment was successfully submitted.";
		AssertJUnit.assertTrue(Actualmsg.equals(Expectedmsg));
		Page.quitBrowser();

	}
}
