package com.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TransferFundsLocators {
	
	//Find all Web Elements on the page
	
	@FindBy(id = "tf_fromAccountId")
	public WebElement FrmAcct;
	
	@FindBy(id = "tf_toAccountId")
	public WebElement ToAcct;
	
	@FindBy(id = "tf_amount")
	public WebElement amt;
	
	@FindBy(id = "tf_description")
	public WebElement desc;
	
	@FindBy(id = "btn_submit")
	public WebElement continuebtn;
	
	@FindBy(xpath = "//button[@id='btn_submit']")
	public WebElement Submitbtn;
	//*[@id="btn_submit"]
			
	@FindBy(xpath = "//div[@class='alert alert-success']")
	public WebElement AlertContent; 

}
