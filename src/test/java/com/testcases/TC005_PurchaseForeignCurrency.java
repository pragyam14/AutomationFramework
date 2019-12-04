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

public class TC005_PurchaseForeignCurrency extends Page {

	@Test(priority = 5)
	
	public void PurchaseForeignCurrency(){
	Page.initConfiguration();
	
	HomePage home = new HomePage();
	home.gotoSignIn();
	log.debug("clicked on SignIn Button");
	
	LoginPage login=new LoginPage();
	login.doLogin("username", "password");
	log.debug("logged in successfully");
	
	AccountSummaryPage asp = new AccountSummaryPage();
	asp.goToPayBills();
	log.debug("clicked to Paybills tab");
	
	PayBillsPage pb = new PayBillsPage();
	pb.ClickPurchaseForeignCurrencyTab();
	pb.CurrencyDropDown().selectByValue("CAD");
	pb.DoPurchaseForeignCurrency("100");
	
	PayBillsLocators locator = new PayBillsLocators();
	AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 10);
	PageFactory.initElements(factory, locator);
	
	String ActualText = locator.alertcontent.getText();
	String ExpectedText = "Foreign currency cash was successfully purchased.";
	AssertJUnit.assertTrue(ActualText.equals(ExpectedText));	
	Page.quitBrowser();

	
}
}