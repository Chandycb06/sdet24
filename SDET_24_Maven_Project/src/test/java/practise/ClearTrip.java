package practise;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class ClearTrip {
   @Test
   public void bookTicket() throws InterruptedException
   {
	   Date d=new Date();
	   String date=d.toString();
	   String[] actDate = date.split(" ");
	   String tickDate = null;
	   for(int i=0;i<actDate.length;i++)
	   {
		   tickDate=actDate[0]+" "+actDate[1]+" "+actDate[2]+" "+actDate[5];
	   }
	   
	   WebDriver driver=new FirefoxDriver();
	   driver.manage().window().maximize();
	   driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	   
	   driver.get("https://www.cleartrip.com/");
	   Thread.sleep(2000);
	   driver.findElement(By.xpath("//h4[.='From']/..//input")).click();
	   driver.findElement(By.xpath("//p[.='Bangalore, IN - Kempegowda International Airport (BLR)']")).click();
	   driver.findElement(By.xpath("//h4[.='To']/..//input")).click();
	   driver.findElement(By.xpath("//p[.='New Delhi, IN - Indira Gandhi Airport (DEL)']")).click();
	   driver.findElement(By.xpath("//h4[.='Depart on']/../../following-sibling::div//button")).click();
	   driver.findElement(By.xpath("//div[@aria-label='"+tickDate+"']")).click();
	   System.out.println("Flight ticket booked");
	   Thread.sleep(3000);
	   driver.quit();
   }
}
