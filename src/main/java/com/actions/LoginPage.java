package com.actions;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.base.Page;
import com.locators.LoginPageLocators;

public class LoginPage extends Page {
	
	public LoginPageLocators login;
	
	public LoginPage() {
		this.login=new LoginPageLocators();
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 10);
		PageFactory.initElements(factory, this.login);
	}

	public void doLogin(String myusername, String mypassword) {
		log.debug("type username");
		//test.log(LogStatus.INFO, "Entering user name");
		login.username.sendKeys(myusername);
		log.debug("type password");
		//test.log(LogStatus.INFO, "Entering password");
		login.password.sendKeys(mypassword);
		log.debug("click submit button");
		//test.log(LogStatus.INFO, "Click Submit Button");
		login.submitBtn.click();
	
		
	}

}
