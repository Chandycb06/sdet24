package practise1test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.Vtiger.genericutilities.FileUtility;

public class DataDrivenScript1 {
    @Test
    public void createOrg()throws Exception
    {
    	FileUtility fui=new FileUtility();
    	String BROWSER = fui.getPropertyKeyValue("browser");
    	String URL = fui.getPropertyKeyValue("url");
    	String USERNAME = fui.getPropertyKeyValue("username");
    	String PASSWORD = fui.getPropertyKeyValue("password");
    	
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
    	driver.findElement(By.name("accountname")).sendKeys("RMG1");
    	driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
    	WebElement ele = driver.findElement(By.xpath("//span[@class='dvHeaderText']"));
    	String text = ele.getText();
    	if(text.contains("RMG"))
    	{
    		System.out.println("organization is created===>pass");
    	}
    }
}
