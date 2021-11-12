package com.crm.vtiger.objectrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Vtiger.genericutilities.WebDriverUtility;

public class CreateOrganizationsPage extends WebDriverUtility{

	@FindBy(name="accountname")
	private WebElement orgNameTxtfd;
	
	@FindBy(name="industry")
	private WebElement indDropdown;
	
	@FindBy(name="accounttype")
	private WebElement TypeDropdown;
	
	@FindBy(xpath="//tbody/tr[1]/td[1]/div[1]/input[1]")
	private WebElement saveButton;
	
	public CreateOrganizationsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getOrgNameTxtfd() {
		return orgNameTxtfd;
	}

	public WebElement getIndDropdown() {
		return indDropdown;
	}

	public WebElement getTypeDropdown() {
		return TypeDropdown;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	
	public void createOrganization(WebDriver driver,String orgName)
	{
		orgNameTxtfd.sendKeys(orgName);
		saveButton.click();
	}
	public void createOrganization(WebDriver driver,String orgName,String indName,String typeName)
	{
		orgNameTxtfd.sendKeys(orgName);
		select(indDropdown, indName);
		select(TypeDropdown, typeName);
		saveButton.click();
	}
}
