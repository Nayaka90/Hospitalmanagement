package com.hms.Objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Admin_DashBoardPage {
	@FindBy(xpath = "//span[.=' Doctors ']")
	private WebElement doctordropdown;

	@FindBy(xpath = "//span[normalize-space(text())='Add Doctor']")
	private WebElement adddoclink;

	@FindBy(xpath = "//span[text()=' Manage Doctors ']")
	private WebElement mngdoclink;

	@FindBy(xpath = "//span[.=' Doctor Specialization ']")
	private WebElement docspllink;

	@FindBy(xpath = "//span[.=' Users ']")
	private WebElement userdropdown;

	@FindBy(xpath = " //span[.=' Appointment History ']")
	private WebElement apmtHisLink;
	
	@FindBy(xpath = "//span[.=' Conatctus Queries ']")
	private WebElement cntctusDropdown;

	@FindBy(xpath = "//span[.=' Unread Query ']")
	private WebElement unreadQueryLink;


	@FindBy(xpath = "//span[.=' Patients ']")
	private WebElement patdropdown;
	
	@FindBy(xpath = "//span[.=' Users ']")
	private WebElement UserDropdown;
	
	@FindBy(xpath = "//span[.=' Manage Users ']")
	private WebElement mngUserLink;
	
	@FindBy(xpath = "//span[.=' Manage Patients ']")
	private WebElement mngPatLink;
	
	
	@FindBy(xpath = "//span[@class='username']")
	private WebElement profiledropdown;

	@FindBy(linkText = "Log Out")
	private WebElement lgoutlink;

	public Admin_DashBoardPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void clickingOnAddDoctor() {
		doctordropdown.click();
		adddoclink.click();
	}
	public void clickingOnMngDoctor() {
		doctordropdown.click();
		mngdoclink.click();
	}

	public void clickingOnAptmtHistory() {
		apmtHisLink.click();
	}

	public void logoutLink() {
		profiledropdown.click();
		lgoutlink.click();
	}
	
	public void clickingOnmanagePatient() {
		patdropdown.click();
		mngPatLink.click();
	}
	public void clickingOnUnReadQuery() {
		cntctusDropdown.click();
		unreadQueryLink.click();
	}
	
	public void clickingOnmanageUser() {
		UserDropdown.click();
		mngUserLink.click();
	}

}
