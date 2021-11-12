package com.crm.vtiger.objectrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsInfoPage {
  
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement orgNameVerify;
	
	@FindBy(xpath="//span[@id='dtlview_Industry']")
	private WebElement indInfo;
	
	@FindBy(xpath="//span[@id='dtlview_Type']")
	private WebElement typeInfo;
	
	public OrganizationsInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getOrgNameVerify() {
		return orgNameVerify;
	}

	public WebElement getIndInfo() {
		return indInfo;
	}

	public WebElement getTypeInfo() {
		return typeInfo;
	}
	
}
