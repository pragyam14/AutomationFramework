package com.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageLocators {
	
	@FindBy(id="user_login")
	public WebElement username;
	
	@FindBy(id="user_password")
	public WebElement password;		
	
	@FindBy(name="submit")
	public WebElement submitBtn;

}
