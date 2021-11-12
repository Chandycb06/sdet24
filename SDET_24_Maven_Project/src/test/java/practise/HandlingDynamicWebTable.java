package practise;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class HandlingDynamicWebTable {
    @Test
    public void webTable() throws InterruptedException
    {
    	//launch the browser
    	WebDriver driver=new ChromeDriver();
    	driver.manage().window().maximize();
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	driver.get("http://localhost:8888");
    	
    	
    	//Login to application
    	driver.findElement(By.name("user_name")).sendKeys("admin");
    	driver.findElement(By.name("user_password")).sendKeys("admin");
    	driver.findElement(By.id("submitButton")).click();
    	
    	driver.findElement(By.linkText("Organizations")).click();
    	//
    	List<WebElement> list = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[1]/input"));
         for(int i=1;i<list.size();i++)
         {
        	 list.get(i).click();
        	 
         }
         Thread.sleep(1000);
         
         //click on last element
         list.get(list.size()-1).click();
         
         Thread.sleep(1000);
         //click on 5th checkboxes
         driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[7]/td[1]/input")).click();
         
         //fetch data of organization
         List<WebElement> txt = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[3]/a"));
         for(int i=1;i<txt.size();i++)
         {
        	 System.out.println(txt.get(i).getText());
         }
         
         String orgName=txt.get(5).getText();
         
         driver.quit();
    }
}
