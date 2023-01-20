package com.hms.Objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hms.generic.ExcelUtility;

public class Medical_HistoryPage {
	@FindBy(xpath = "//i[@class='fa fa-eye']")
	private WebElement eyeIcon;

	@FindBy(xpath = " //table[@id='datatable']//tr[3]/td[2]")
	private WebElement bloodPressureValueIntable;

	@FindBy(xpath = "//span[@class='username']")
	private WebElement profiledropdown;
	
	@FindBy(linkText  = "Log Out")
	private WebElement lgoutlink;
	
	
	public Medical_HistoryPage(WebDriver driver) {
		PageFactory.initElements(driver, this);	
	}
	public String verifyingMedHistory(ExcelUtility eul) throws Throwable {
		eyeIcon.click();
		String text=bloodPressureValueIntable.getText();
		return text;
	}
	
	

}
