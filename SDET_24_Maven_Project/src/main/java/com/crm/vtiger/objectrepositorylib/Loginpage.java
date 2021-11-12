package com.crm.vtiger.objectrepositorylib;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Vtiger.genericutilities.FileUtility;

public class Loginpage {     //Rule 1:Create java class for every webpage present in a application
   
	public WebDriver driver; //Global variable 
	@FindBy(name="user_name") //Rule 2:Identify all the elements by @findby, @findbys and @findall annotations and store them in a class
	private WebElement usernameTxtfd;
	
	@FindBy(name="user_password")
	private WebElement passwordTxtfd;
	
	@FindBy(id="submitButton")
	private WebElement loginbtn;
	
	public Loginpage(WebDriver driver) //Rule 3:Execute all the elements & initialize that elements by using pagefacory.initElements()
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getUsernameTxtfd() { //Rule 4:Declare webelement as private and provide getter method to acess elements in testscripts class
		return usernameTxtfd;
	}

	public WebElement getPasswordTxtfd() {
		return passwordTxtfd;
	}

	public WebElement getLoginbtn() {
		return loginbtn;
	}
	
	FileUtility fu=new FileUtility();
	
	//Method Overloading---->Predefined method(using common username and password)
	public void loginToAppln() throws Exception //Rule 5:Develop a business library in a pom class
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(fu.getPropertyKeyValue("url"));
		driver.manage().window().maximize();
		usernameTxtfd.sendKeys("admin");
		passwordTxtfd.sendKeys("admin");
		loginbtn.click();
		
	}
	//Method Overloading----->Userdefined method(using userdefined username and password)
	public void loginToAppln(String username,String password) throws Exception
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(fu.getPropertyKeyValue("url"));
		driver.manage().window().maximize();
		usernameTxtfd.sendKeys(username);
		passwordTxtfd.sendKeys(password);
		loginbtn.click();
	}
}
