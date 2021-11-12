package com.crm.vtiger.objectrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {
   
	public WebDriver driver;// Global variable
	
	@FindBy(linkText="Organizations") // store elements in pom class using findby
	private WebElement OrganizationsTab;
	
	@FindBy(linkText="Contacts")
	private WebElement ContactsTab;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement Administrator;
	
	@FindBy(linkText="Sign Out")
	private WebElement SignOutLink;
	
	public Homepage(WebDriver driver) // using constructor initialize the elements
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getOrganizationsTab() { //using getters return the address of the element
		return OrganizationsTab;
	}


	public WebElement getContactsTab() {
		return ContactsTab;
	}


	public WebElement getAdministrator() {
		return Administrator;
	}


	public WebElement getSignOutLink() {
		return SignOutLink;
	}


	public void logOutAppln(){
		Actions act=new Actions(driver);
		act.moveToElement(Administrator).perform();
		SignOutLink.click();
	}
}
