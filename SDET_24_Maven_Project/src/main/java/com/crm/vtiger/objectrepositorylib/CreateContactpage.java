package com.crm.vtiger.objectrepositorylib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Vtiger.genericutilities.WebDriverUtility;

public class CreateContactpage {

	@FindBy(name="lastname")
	private WebElement lastNametxtfd;
	
	@FindBy(xpath="//input[@name='account_name']/following-sibling::img")
	private WebElement orgNamelookup;
	
	@FindBy(xpath="//tbody/tr[1]/td[1]/div[1]/input[1]")
	private WebElement saveButton;
	
	public CreateContactpage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getLastNametxtfd() {
		return lastNametxtfd;
	}

	public WebElement getOrgNamelookup() {
		return orgNamelookup;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	
	public void createContact(WebDriver driver,String lastName)
	{
		lastNametxtfd.sendKeys(lastName);
		saveButton.click();
	}
	
	WebDriverUtility wu=new WebDriverUtility();
	public void createContact(WebDriver driver,String lastName,String orgName)
	{
		lastNametxtfd.sendKeys(lastName);
		orgNamelookup.click();
		wu.switchToWindow(driver, "Accounts&action");
		Organizationspage op=new Organizationspage(driver);
		op.getSearchTxtfd().sendKeys(orgName);
		op.getSerachBtn().click();
		driver.findElement(By.xpath("//a[.='"+orgName+"']")).click();
		wu.switchToWindow(driver, "Contacts&action");
		saveButton.click();
	}
}
