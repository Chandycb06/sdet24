package practise1test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.Vtiger.genericutilities.ExcelUtility;
import com.Vtiger.genericutilities.FileUtility;

public class DataDrivenScript2 {
  public static void main(String[] args) throws Exception {
	  FileUtility fui=new FileUtility();
  	String BROWSER = fui.getPropertyKeyValue("browser");
  	String URL = fui.getPropertyKeyValue("url");
  	String USERNAME = fui.getPropertyKeyValue("username");
  	String PASSWORD = fui.getPropertyKeyValue("password");
  	
  	ExcelUtility eu=new ExcelUtility();
  	String testcasename="tc_01";
  	String tc=eu.getData("Sheet1", 1, 0);
  	String orgName = null;
  	if(tc.equals(testcasename)){
  	orgName = eu.getData("Sheet1", 1, 2);
  	}
  	
  	WebDriver driver=null;
	if(BROWSER.equals("firefox")){
		driver=new FirefoxDriver();
	}else if(BROWSER.equals("chrome")){
		driver=new ChromeDriver();
	}
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.get(URL);
	driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	driver.findElement(By.id("submitButton")).click();
	driver.findElement(By.linkText("Organizations")).click();
	driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
	driver.findElement(By.name("accountname")).sendKeys(orgName);
	driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
	WebElement ele = driver.findElement(By.xpath("//span[@class='dvHeaderText']"));
	String text = ele.getText();
	if(text.contains(orgName))
	{
		System.out.println("organization is created===>pass");
		eu.createData("Sheet1", 1, 3,"Pass");
	}else{
		System.out.println("organization is not created===>fail");
		eu.createData("Sheet1", 1, 3,"Fail");
	}
	driver.close();
}
}
