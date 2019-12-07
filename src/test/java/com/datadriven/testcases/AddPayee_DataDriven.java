package com.datadriven.testcases;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.actions.AccountSummaryPage;
import com.actions.HomePage;
import com.actions.LoginPage;
import com.actions.PayBillsPage;
import com.base.Page;
import com.locators.PayBillsLocators;

public class AddPayee_DataDriven extends Page {

	
	@Test(dataProvider ="Payee")
	public void AddnewPayee_datadriven (String p_name,String p_address, String p_account, String p_details ) {
		Page.initConfiguration();
		
		HomePage home = new HomePage();
		home.gotoSignIn();
		LoginPage login=new LoginPage();
		login.doLogin("username", "password");
		AccountSummaryPage asp = new AccountSummaryPage();
		asp.goToPayBills();
		PayBillsPage pb = new PayBillsPage();
		pb.goToAddNewPayee();
		PayBillsLocators locator = new PayBillsLocators();
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 10);
		PageFactory.initElements(factory, locator);
		
		locator.PayeeName.sendKeys(p_name);
		locator.PayeeAddress.sendKeys(p_address);
		locator.Account.sendKeys(p_account);
		locator.Details.sendKeys(p_details);		
		locator.ClickAdd.click();
		
		Page.quitBrowser();
	}
	
	@DataProvider(name="Payee")
	public Object[][] passdata() {
		int rows=excel.getRowCount(1);
		Object[][] data = new Object[rows][4];
		for(int i=0; i<rows; i++) {
			for(int j=0; j<4; j++) {
			data[i][j]=excel.getData(1, i, j);
			}
		}
		return data;
	}

}
