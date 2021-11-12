package practise;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FlightTicket1 {
    
	@Test
	public void bookTicket() throws InterruptedException
	   {
		  /* Date d=new Date();
		   String date=d.toString();
		   String[] actDate = date.split(" ");
		   String tickDate = null;
		   for(int i=0;i<actDate.length;i++)
		   {
			   tickDate=actDate[0]+" "+actDate[1]+" "+actDate[2]+" "+actDate[5];
		   }*/
		   
		   WebDriver driver=new ChromeDriver();
		   driver.manage().window().maximize();
		   driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		   
		   driver.get("https://www.makemytrip.com/");
		   Thread.sleep(2000);
		   driver.findElement(By.xpath("//body/div[@id='root']/div[1]/div[1]/div[1]/div[1]/ul[1]/li[3]/div[2]")).click();
		  
		   driver.findElement(By.xpath("//span[.='From']")).click();
		   driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys("BOM");
		   driver.findElement(By.xpath("//div[.='BOM']")).click();
		   
		   driver.findElement(By.xpath("//span[.='To']")).click();
		   driver.findElement(By.xpath("//input[@placeholder='To']")).sendKeys("Chennai International Airport India");
		   Thread.sleep(1000);
		   driver.findElement(By.xpath("//p[contains(text(),'Chennai, India')]")).click();
		   
		   driver.findElement(By.xpath("//p[@data-cy='departureDate']")).click();
		   driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
		   driver.findElement(By.xpath("//div[@aria-label='Tue Jan 25 2022']")).click();
		 
	   }
}
