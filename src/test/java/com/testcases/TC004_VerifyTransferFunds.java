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
import com.actions.TransferFundsPage;
import com.base.Page;
import com.locators.TransferFundsLocators;

public class TC004_VerifyTransferFunds extends Page {
	
	@Test(priority = 4)
	public void verifyTransferFunds() {
		
		Page.initConfiguration();
		log.debug("Login Test Started.");
		//test.log(LogStatus.INFO, "Login Test started");
		
		HomePage home = new HomePage();
		home.gotoSignIn();
		log.debug("Clicked on SignIn Button");
		
		LoginPage login=new LoginPage();
		login.doLogin("username", "password");
		
		AccountSummaryPage asp = new AccountSummaryPage();
		asp.goToTransferFund();
		
		TransferFundsPage tf = new TransferFundsPage();
		tf.SelectFrmAcct().selectByValue("2");
		tf.SelectToAccount().selectByValue("3");
		tf.DoTransferFunds("100", "Donation");
		
		TransferFundsLocators locator = new TransferFundsLocators();
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 10);
		PageFactory.initElements(factory, locator);
		
		String Actualmsg = locator.AlertContent.getText();
		String Expectedmsg = "You successfully submitted your transaction.";
		AssertJUnit.assertEquals(Actualmsg, Expectedmsg);
		Page.quitBrowser();
	}
	
	

}
