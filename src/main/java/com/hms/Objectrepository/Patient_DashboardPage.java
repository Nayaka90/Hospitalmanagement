package com.hms.Objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Patient_DashboardPage {
	@FindBy(xpath = "//span[.=' Book Appointment ']")
	private WebElement bookApmtlink;

	@FindBy(xpath = " //span[.=' Medical History '] ")
	private WebElement medHislink;

	@FindBy(xpath = "//span[@class='username']")
	private WebElement profiledropdown;
	
	@FindBy(linkText  = "Log Out")
	private WebElement lgoutlink;
	
	
	public Patient_DashboardPage(WebDriver driver) {
		PageFactory.initElements(driver, this);	
	}
	public void clickingOnmedHistory() {
		medHislink.click();
		
	}
	
	public void clickingOnBookApmt() {
		bookApmtlink.click();
		
	}
	public void logoutLink() {
		profiledropdown.click();
		lgoutlink.click();
	}

}
