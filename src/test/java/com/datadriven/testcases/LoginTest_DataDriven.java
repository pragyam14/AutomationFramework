package com.datadriven.testcases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.actions.HomePage;
import com.base.Page;
import com.locators.LoginPageLocators;

	
public class LoginTest_DataDriven extends Page {
	
	
	@Test(dataProvider ="Credential")
		public void login_datadriven(String UserName, String Password) {
		
		Page.initConfiguration();
		
		HomePage home = new HomePage();
		home.gotoSignIn();
//		LoginPage login=new LoginPage();
//		login.doLogin(UserName, Password);
		
		LoginPageLocators login = new LoginPageLocators();
		//this.login=new LoginPageLocators();
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 10);
		PageFactory.initElements(factory, login);
		
		
		log.debug("type username");
		//test.log(LogStatus.INFO, "Entering username");
		login.username.sendKeys(UserName);
		log.debug("type password");
		//test.log(LogStatus.INFO, "Entering password");
		login.password.sendKeys(Password);
		log.debug("click submit button");
		//test.log(LogStatus.INFO, "Click Submit Button");
		login.submitBtn.click();
		
		
		
		String actual = Page.driver.getTitle();
		String expected="Zero - Account Summary";
		AssertJUnit.assertEquals(actual, expected);
		
		Page.quitBrowser();
		
		
	   }
	
	@DataProvider(name="Credential")
	public Object[][] passdata() {

		int rows=excel.getRowCount(0);
		Object[][] data = new Object[rows][2];
		for(int i=0; i<rows; i++) {
			data[i][0]=excel.getData(0, i, 0);									                   
			data[i][1]=excel.getData(0, i, 1);
		}
		return data;

	}



}