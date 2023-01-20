package com.hms.Objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hms.generic.ExcelUtility;

public class Manage_DoctorsPage{
	

	@FindBy(name = "submit")
	private WebElement submitbtn;
	
	@FindBy(xpath = "//a[@tooltip='Remove']")
	private WebElement removeIcon;
	

	public Manage_DoctorsPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
  public void removeDoc() {
	  
  }
}
