package com.crm.vtiger.objectrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Contactspage {
   
	@FindBy(xpath="//img[@alt='Create Contact...']")
	private WebElement createContactButton;
	
	public Contactspage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreateContactButton() {
		return createContactButton;
	}
	
}
