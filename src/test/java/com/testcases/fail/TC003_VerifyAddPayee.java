package com.testcases.fail;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
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

public class TC003_VerifyAddPayee extends Page {
	
	@Test(priority = 3)
	
		public void VerifyAddPayee(){
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
		pb.goToAddNewPayee();
		log.debug("clicked to Add New Payee Tab");
		pb.createNewPayee("HydroOne Utility","200 RoberSpec Pkwy, Mississauga, ON  L6R1K9","123234434","Natural Gas Utility");
		
		PayBillsLocators locator = new PayBillsLocators();
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 10);
		PageFactory.initElements(factory, locator);
				
		String Expectedmsg = locator.alertcontent.getText();
		String Actualmsg = "The new payee HydroOne Utility was successfully created.test";
		AssertJUnit.assertEquals(Actualmsg, Expectedmsg);
		log.debug("new payee is being successfully added");
		 
		 Page.quitBrowser();
	}
}
