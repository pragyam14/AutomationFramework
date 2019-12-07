package com.datadriven.testcases;

import org.testng.annotations.Test;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import com.actions.HomePage;
import com.base.Page;
import com.locators.LoginPageLocators;

public class LoginTest_DataDriven extends Page {
	
	@Test(dataProvider ="Credential")
		public void login_datadriven(String UserName, String Password) {
		
		Page.initConfiguration();
		
		HomePage home = new HomePage();
		home.gotoSignIn();
		
		LoginPageLocators login = new LoginPageLocators();
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 10);
		PageFactory.initElements(factory, login);
		
		log.info("type username");
		login.username.sendKeys(UserName);
		log.info("type password");
		login.password.sendKeys(Password);
		log.info("click on submit button");
		login.submitBtn.click();
		
		String actual = Page.driver.getTitle();
		String expected="Zero - Account Summary";
		Assert.assertEquals(actual, expected);
		
		Page.quitBrowser();		
	   }
	
	@DataProvider(name="Credential")
	public Object[][] passdata() {
		int rows=excel.getRowCount(0);
		Object[][] data = new Object[rows][2];
		for(int i=0; i<rows; i++) {
			for(int j=0; j<2; j++) {
			data[i][j]=excel.getData(0, i, j);
			}
		}
		return data;
	}
}