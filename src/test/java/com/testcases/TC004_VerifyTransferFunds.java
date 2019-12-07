package com.testcases;

import org.testng.annotations.Test;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Assert;
import com.actions.AccountSummaryPage;
import com.actions.HomePage;
import com.actions.LoginPage;
import com.actions.TransferFundsPage;
import com.base.Page;
import com.locators.TransferFundsLocators;
import com.relevantcodes.extentreports.LogStatus;

public class TC004_VerifyTransferFunds extends Page {
	
	@Test(priority = 4)
	public void verifyTransferFunds() {
		
		Page.initConfiguration();
		
		HomePage home = new HomePage();
		home.gotoSignIn();
		log.debug("Clicked on SignIn Button");
		
		LoginPage login=new LoginPage();
		login.doLogin("username", "password");
		log.info("Logged into Zero Banking successfully");
		test.log(LogStatus.INFO, "Logged into Zero Banking successfully");
		
		AccountSummaryPage asp = new AccountSummaryPage();
		asp.goToTransferFund();
		log.info("Cliked on Transfer Funds tab successfully");
		
		TransferFundsPage tf = new TransferFundsPage();
		tf.SelectFrmAcct().selectByValue("2");
		tf.SelectToAccount().selectByValue("3");
		tf.DoTransferFunds("100", "Donation");
		
		TransferFundsLocators locator = new TransferFundsLocators();
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 10);
		PageFactory.initElements(factory, locator);
		
		String Actualmsg = locator.AlertContent.getText();
		String Expectedmsg = "You successfully submitted your transaction.";
		Assert.assertEquals(Actualmsg, Expectedmsg);
		log.info("FundsTransfer done successfully");
		test.log(LogStatus.INFO, "FundsTransfer done successfully");

		Page.quitBrowser();
	}
}
