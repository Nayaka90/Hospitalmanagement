package com.hms.Objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;

import com.hms.generic.ExcelUtility;
import com.hms.generic.WebDriverUtility;

public class Book_ApointmentPage extends WebDriverUtility{
	
	
	@FindBy(name = "Doctorspecialization")
	private WebElement docSpecialzationListBox;

	@FindBy(name = "doctor")
	private WebElement docListBox;

	@FindBy(name = "appdate")
	private WebElement dateTxtBox;

	@FindBy(name = "apptime")
	private WebElement timeTxtBox;

	@FindBy(name = "submit")
	private WebElement sbmtBtn;
	
	
	
	
	public Book_ApointmentPage(WebDriver driver) {
		PageFactory.initElements(driver, this);	
	}

	public void clickingOnBookApmt(String Browser,ExcelUtility eul) throws Throwable {
		select(docSpecialzationListBox, eul.getDataFromExcel(Browser,"AddPat_MngPat", 3, 1));
		select(docListBox,eul.getDataFromExcel(Browser,"AddPat_MngPat", 2, 1));
		dateTxtBox.sendKeys(eul.getDataFromExcel(Browser,"Add_Pat", 0, 5));
		timeTxtBox.sendKeys(eul.getDataFromExcel(Browser,"Add_Pat", 1, 5));
		sbmtBtn.click();
	}

}
