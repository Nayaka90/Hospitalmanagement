package com.hms.Objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;

import com.hms.generic.ExcelUtility;

public class ContactUs_Page {
	@FindBy(name="mobileno")
	private WebElement mobilenotxtbx;
	
	@FindBy(name="description")
	private WebElement descriptiontxtbx;
	
	@FindBy(name="submit")
	private WebElement submitbtn;	

	@FindBy(name="fullname")
	private WebElement fullNametxtbx;

	@FindBy(name="emailid")
	private WebElement emailtxtbx;

	public ContactUs_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void contactusQuery(String Browser,ExcelUtility eul) throws Throwable {
		fullNametxtbx.sendKeys(eul.getDataFromExcel(Browser,"ContactUs_Queries", 0, 1));
		emailtxtbx.sendKeys(eul.getDataFromExcel(Browser,"ContactUs_Queries", 1, 1));
		mobilenotxtbx.sendKeys(eul.getDataFromExcel(Browser,"ContactUs_Queries", 2, 1));
		descriptiontxtbx.sendKeys(eul.getDataFromExcel(Browser,"ContactUs_Queries", 3, 1));
		submitbtn.click();
	}
}
