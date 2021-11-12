package Old;

import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.Vtiger.genericutilities.ExcelUtility;
import com.Vtiger.genericutilities.FileUtility;

public class CreateContact {
     @Test
     public void createContact()throws Exception
     {
        FileUtility fui=new FileUtility();
     	String BROWSER =fui.getPropertyKeyValue("browser");
 	  	String URL = fui.getPropertyKeyValue("url");
 	  	String USERNAME =fui.getPropertyKeyValue("username");
 	  	String PASSWORD =fui.getPropertyKeyValue("password");
     	Random random=new Random();
 	  	int randomNum = random.nextInt(100);
 	  	ExcelUtility eu=new ExcelUtility();
 	  	String orgname =eu.getData("Contact", 1, 2)+"_"+randomNum;
     	String conname=eu.getData("Contact", 1, 3)+"_"+randomNum;
     	
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
 		
 		WebDriverWait wait=new WebDriverWait(driver, 10);
 		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.linkText("Contacts"))));
 		driver.findElement(By.linkText("Contacts")).click();
 		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
 		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(conname);
 		driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img")).click();
 		Set<String> set = driver.getWindowHandles();
 		String parentid = driver.getWindowHandle();
 		Iterator<String> it=set.iterator();
 		while(it.hasNext()){
 			String windowid = it.next();
 			driver.switchTo().window(windowid);
 			if((driver.getTitle()).contains("Accounts&action"))
 			{
 				break;
 			}
 		}
 		driver.findElement(By.xpath("//input[@name='search_text']")).sendKeys(orgname);
 		driver.findElement(By.xpath("//input[@name='search']")).click();
 		driver.findElement(By.xpath("//a[.='"+orgname+"']")).click();
 		driver.switchTo().window(parentid);
 		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
 		WebElement ele1 = driver.findElement(By.xpath("//span[contains(text(),'Contact Information')]"));
 		String txt = ele1.getText();
 		if(txt.contains(conname))
 		{
 			System.out.println("organization is created===>pass");
 		}else{
 			System.out.println("organization is not created===>fail");
 		}
 		driver.close();
     }
}
