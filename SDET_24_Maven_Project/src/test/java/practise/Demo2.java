package practise;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Demo2 {
	@Test
	  public void script2()throws Exception
	  {
		  System.setProperty("webdriver.chrome.driver", "./Softwares/chromedriver.exe");
		  WebDriver driver=new ChromeDriver();
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  driver.manage().window().maximize();
		  driver.get("http://localhost:8084/");
		  Thread.sleep(2000);
	  	  driver.findElement(By.xpath("//input[@id='usernmae']")).sendKeys("rmgyantra");
	  }
}
