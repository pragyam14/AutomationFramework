package com.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PayBillsLocators {
	
	@FindBy(xpath="//a[@text()='Add New Payee']")
	public WebElement addnewpayeebtn;
	
	@FindBy(id="np_new_payee_name")
	public WebElement payeename;
	
	@FindBy(id="np_new_payee_address")
	public WebElement payeeaddress;
	
	@FindBy(id="np_new_payee_account")
	public WebElement payeeano;
	
	@FindBy(id="np_new_payee_details")
	public WebElement payeedetails;
	
	@FindBy(id="add_new_payee")
	public WebElement npayeeadd;

}
