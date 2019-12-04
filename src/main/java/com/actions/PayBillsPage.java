package com.actions;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;

import com.base.Page;
import com.locators.PayBillsLocators;

public class PayBillsPage extends Page {
	
	public PayBillsLocators paybills;
	public PayBillsPage() {
		this.paybills=new PayBillsLocators();
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 30);
		PageFactory.initElements(factory, this.paybills);
	}
	
	public PayBillsPage goToAddNewPayee() {
		paybills.AddPayeeTab.click();
		return this;
	}
	
	public void createNewPayee(String pname,String paddress,String paccount,String pdetails) {
		paybills.PayeeName.sendKeys(pname);
		paybills.PayeeAddress.sendKeys(paddress);
		paybills.Account.sendKeys(paccount);
		paybills.Details.sendKeys(pdetails);		
		paybills.ClickAdd.click();	
	}
	
	public Select SelectPayee() {
		return new Select(paybills.Payee);
	}
	public Select SelectAccount() {
		return new Select(paybills.acct);
	}
	public void PayPayee(String amount, String pickdate, String description) {
		paybills.amt.sendKeys(amount);
		paybills.date.sendKeys(pickdate);
		paybills.desc.sendKeys(description);
		paybills.paybtn.click();
	}
	public void ClickPurchaseForeignCurrencyTab(){
		paybills.PurchaseForeignCurrencyTab.click();	
	}
	
	public Select CurrencyDropDown() {
		return new Select(paybills.Currency);
	}
	
	public void DoPurchaseForeignCurrency(String Amount) {
		paybills.pfamt.sendKeys(Amount);
		paybills.USDRadioBtn.click();
		paybills.CalcCost.click();
		paybills.PurchaseBtn.click();
	}
}