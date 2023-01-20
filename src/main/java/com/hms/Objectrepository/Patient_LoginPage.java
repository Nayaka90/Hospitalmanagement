package com.hms.Objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;

import com.hms.generic.ExcelUtility;

public class Patient_LoginPage {

	@FindBy(name = "username")
	private WebElement usernametxtbx;

	@FindBy(name = "password")
	private WebElement passwordtxtbx;

	@FindBy(name = "submit")
	private WebElement submitbtn;
	
	@FindBy(partialLinkText = "Create")
	private WebElement createacntlink;

	public Patient_LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void patientLogin(String Browser,ExcelUtility eul) throws Throwable {
		usernametxtbx.sendKeys(eul.getDataFromExcel(Browser,"AddPat_MngPat", 4, 1));
		passwordtxtbx.sendKeys(eul.getDataFromExcel(Browser,"AddPat_MngPat", 5, 1));
		submitbtn.click();
	}
	public void createacntlink() {
		createacntlink.click();
	}

}
