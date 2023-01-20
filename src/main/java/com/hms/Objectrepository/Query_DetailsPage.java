package com.hms.Objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hms.generic.ExcelUtility;

public class Query_DetailsPage {
	@FindBy(name = "adminremark")
	private WebElement adminremarkTxtBx;

	@FindBy(name = "update")
	private WebElement UpdateBtn;

	@FindBy(xpath = "//span[text()=' Manage Doctors ']")
	private WebElement mngdoclink;
	
	public Query_DetailsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void adminRemark(String Browser,ExcelUtility eul) throws Throwable {
		adminremarkTxtBx.sendKeys(eul.getDataFromExcel(Browser,"ContactUs_Queries", 4, 1));
		UpdateBtn.click();
	}
}
