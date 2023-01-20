package com.hms.Objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Doctor_DashboardPage {
	@FindBy(xpath = " //span[.=' Patients ']")
	private WebElement patDropDown;

	@FindBy(xpath = " //span[.=' Add Patient']")
	private WebElement addPatietlink;

	@FindBy(xpath = " //span[.=' Manage Patient ']")
	private WebElement mngPatientlink;

	@FindBy(xpath = "//span[.=' Search ']")
	private WebElement searchlink;

//	@FindBy(xpath = "//span[.=' Users ']")
//	private WebElement userdropdown;
//	
	@FindBy(xpath = "//span[@class='username']")
	private WebElement profiledropdown;
	
	@FindBy(linkText  = "Log Out")
	private WebElement lgoutlink;
	
	
	public Doctor_DashboardPage(WebDriver driver) {
		PageFactory.initElements(driver, this);	
	}
	
	public void clickingOnaddPatietlink() {
		patDropDown.click();
		addPatietlink.click();
		
	}
	public void logoutLink() {
		profiledropdown.click();
		lgoutlink.click();
	}

	public void clickOnSearhIcon() {
		searchlink.click();
	}

}
