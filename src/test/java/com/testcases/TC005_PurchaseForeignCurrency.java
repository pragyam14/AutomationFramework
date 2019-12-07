package com.testcases;

import org.testng.annotations.Test;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Assert;
import com.actions.AccountSummaryPage;
import com.actions.HomePage;
import com.actions.LoginPage;
import com.actions.PayBillsPage;
import com.base.Page;
import com.locators.PayBillsLocators;
import com.relevantcodes.extentreports.LogStatus;

public class TC005_PurchaseForeignCurrency extends Page {

	@Test(priority = 5)
	public void PurchaseForeignCurrency(){
	Page.initConfiguration();
	
	HomePage home = new HomePage();
	home.gotoSignIn();
	log.info("clicked on SignIn Button");
	
	LoginPage login=new LoginPage();
	login.doLogin("username", "password");
	log.debug("logged in successfully");
	
	AccountSummaryPage asp = new AccountSummaryPage();
	asp.goToPayBills();
	log.info("clicked to Paybills tab successfully");
	
	PayBillsPage pb = new PayBillsPage();
	pb.ClickPurchaseForeignCurrencyTab();
	log.info("clicked to Purchase Foreign Currency tab successfully");
	test.log(LogStatus.INFO, "Purchase Foreign Currency tab opened up successfully");

	pb.CurrencyDropDown().selectByValue("CAD");
	pb.DoPurchaseForeignCurrency("100");
	
	PayBillsLocators locator = new PayBillsLocators();
	AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 10);
	PageFactory.initElements(factory, locator);
	
	String ActualText = locator.alertcontent.getText();
	String ExpectedText = "Foreign currency cash was successfully purchased.";
	Assert.assertTrue(ActualText.equals(ExpectedText));	
	log.info("Foreign currency is being successfully purchased");
	test.log(LogStatus.INFO, "Foreign currency is being successfully purchased");


	Page.quitBrowser();

	
}
}