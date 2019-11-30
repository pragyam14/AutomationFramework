package com.actions;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.base.Page;
import com.locators.PayBillsLocators;

public class PayBills extends Page {
	
	public PayBillsLocators paybills;
	public PayBills() {
		this.paybills=new PayBillsLocators();
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 30);
		PageFactory.initElements(factory, this.paybills);
	}
	
	public PayBills goToAddNewPayee() {
		paybills.addnewpayeebtn.click();
		return this;
	}
	
	public void createNewPayee(String pname, String paddress, String paccno, String pdetails) {
		paybills.payeename.sendKeys(pname);
		paybills.payeeaddress.sendKeys(paddress);
		paybills.payeeano.sendKeys(paccno);
		paybills.payeedetails.sendKeys(pdetails);
		paybills.npayeeadd.click();
	}

}
