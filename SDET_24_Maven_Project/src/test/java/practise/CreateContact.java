package practise;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.Vtiger.genericutilities.ExcelUtility;
import com.Vtiger.genericutilities.FileUtility;
import com.Vtiger.genericutilities.JavaUtility;
import com.Vtiger.genericutilities.WebDriverUtility;

public class CreateContact {
	@Test
    public void createContact()throws Exception
    {
		WebDriver driver=new FirefoxDriver();
		WebDriverUtility wu=new WebDriverUtility();
		JavaUtility ju=new JavaUtility();
        FileUtility fui=new FileUtility();
	  	String USERNAME =fui.getPropertyKeyValue("username");
	  	String PASSWORD =fui.getPropertyKeyValue("password");
    	//fetch the data from excel and store in variable
	  	ExcelUtility eu=new ExcelUtility();
	  	String orgname =eu.getData("Contact", 1, 2)+"_"+ju.getRandomNum();
    	String conname=eu.getData("Contact", 1, 3)+"_"+ju.getRandomNum();
    	
    	//
		wu.waitUntilPageLoad(driver);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys(orgname);
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		WebElement ele = driver.findElement(By.xpath("//span[@class='dvHeaderText']"));
		String text = ele.getText();
		if(text.contains(orgname))
		{
			System.out.println("organization is created===>pass");
		}else{
			System.out.println("organization is not created===>fail");
		}
		
		wu.waitForElementVisibility(driver, (driver.findElement(By.linkText("Contacts"))));
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(conname);
		driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img")).click();
		wu.switchToWindow(driver, "Accounts&action");
		driver.findElement(By.xpath("//input[@name='search_text']")).sendKeys(orgname);
		driver.findElement(By.xpath("//input[@name='search']")).click();
		driver.findElement(By.xpath("//a[.='"+orgname+"']")).click();
		wu.switchToWindow(driver, "Contacts&action");
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		WebElement ele1 = driver.findElement(By.xpath("//span[contains(text(),'Contact Information')]"));
		String txt = ele1.getText();
		if(txt.contains(conname))
		{
			System.out.println("Contact Name is created===>pass");
		}else{
			System.out.println("Contact Name is not created===>fail");
		}
		driver.close();
    }
}
