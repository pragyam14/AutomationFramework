package com.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PayBillsLocators {
	
	//Find all WebElements for Add Payee Sub-Tab
		@FindBy(linkText = "Add New Payee")          //xpath=("//a[@text()='Add New Payee']")            
		public WebElement AddPayeeTab;								
		
		@FindBy(xpath = "//input[@id='np_new_payee_name']") 	
		public WebElement PayeeName;
		
		@FindBy(id = "np_new_payee_address")
		public WebElement PayeeAddress;
		
		@FindBy(id = "np_new_payee_account")
		public WebElement Account;
		
		@FindBy(id = "np_new_payee_details")
		public WebElement Details;
		
		@FindBy(css = "input#add_new_payee")
		public WebElement ClickAdd;
		
		@FindBy(xpath = "//div[@id='alert_content']")
		public WebElement alertcontent;
		
		//Find all the WebElements for Pay Saved Payee Sub-Tab		
		@FindBy(id = "sp_payee")
		public WebElement Payee;
		
		@FindBy(id = "sp_account")
		public WebElement acct;
		
		@FindBy(id = "sp_amount")
		public WebElement amt;
		
		@FindBy(id = "sp_date")
		public WebElement date;
		
		@FindBy(id = "sp_description")
		public WebElement desc;
		
		@FindBy(id = "pay_saved_payees")
		public WebElement paybtn;
		
		@FindBy(xpath = "//div[@id='alert_content']") 
		public WebElement SuccessMsg;
		
		//Find all WebElement for Purchase Foreign Currency Sub-Tab
		@FindBy(linkText = "Purchase Foreign Currency")
		public WebElement PurchaseForeignCurrencyTab;

		@FindBy(id = "pc_currency")
		public WebElement Currency;
		
		@FindBy(id = "pc_amount")
		public WebElement pfamt;

		@FindBy(id = "pc_inDollars_true")
		public WebElement USDRadioBtn;
		
		@FindBy(id = "pc_calculate_costs")
		public WebElement CalcCost;
		
		@FindBy(id = "purchase_cash")
		public WebElement PurchaseBtn;
		
		@FindBy(id = "alert_content")
		public WebElement AlertMsg;



}
