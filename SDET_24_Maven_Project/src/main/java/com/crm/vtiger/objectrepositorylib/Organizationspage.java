package com.crm.vtiger.objectrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Organizationspage {
   
	@FindBy(xpath="//img[@title='Create Organization...']")
	private WebElement CreateOrgButton;
	
	@FindBy(xpath="//input[@name='search_text']")
	private WebElement searchTxtfd;
	
	@FindBy(xpath="//input[@name='search']")
	private WebElement serachBtn;
	
	public Organizationspage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreateOrgButton() {
		return CreateOrgButton;
	}
	
	public WebElement getSearchTxtfd() {
		return searchTxtfd;
	}

	public WebElement getSerachBtn() {
		return serachBtn;
	}
}
