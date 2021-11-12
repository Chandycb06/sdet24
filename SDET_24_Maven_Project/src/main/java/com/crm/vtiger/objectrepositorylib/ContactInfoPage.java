package com.crm.vtiger.objectrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage {
   
	@FindBy(xpath="//span[contains(text(),'Contact Information')]")
    private WebElement conNameVerify;
   
   public ContactInfoPage(WebDriver driver)
   {
	   PageFactory.initElements(driver, this);
   }

public WebElement getConNameVerify() {
	return conNameVerify;
}
   
}
