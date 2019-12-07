package com.actions;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;

import com.base.Page;
import com.locators.TransferFundsLocators;

public class TransferFundsPage extends Page {
	
	public TransferFundsLocators transfunds;
	public TransferFundsPage() {
		this.transfunds=new TransferFundsLocators();
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 10);
		PageFactory.initElements(factory, this.transfunds);
	}
	

	public Select SelectFrmAcct() {
		return new Select(transfunds.FrmAcct);
	}
	
	public Select SelectToAccount() {
		return new Select(transfunds.ToAcct);
	}
	
	public void DoTransferFunds(String Amount, String Description) {
		transfunds.amt.sendKeys(Amount);
		transfunds.desc.sendKeys(Description);
		transfunds.continuebtn.click();
		transfunds.Submitbtn.click();
	}
	
}
