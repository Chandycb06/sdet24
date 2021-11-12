package Old;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.Vtiger.genericutilities.ExcelUtility;

public class createOrgWithIndTest {
	@Test
	  public void createOrgWithIndustries()throws Exception
	  {
		System.out.println("CREATEEE");
		String BROWSER = System.getProperty("browser");
	  	String URL = System.getProperty("url");
	  	String USERNAME = System.getProperty("username");
	  	String PASSWORD = System.getProperty("password");
		  	
		  	Random random=new Random();
		  	int randomNum = random.nextInt(100);
		  	ExcelUtility eu=new ExcelUtility();
		  	Thread.sleep(1000);
		  	String orgName = eu.getData("Sheet1", 1, 2)+"_"+randomNum;
		  	Thread.sleep(1000);
		  	String industries=eu.getData("Sheet1", 1, 3);
		  	Thread.sleep(1000);
		  	String type=eu.getData("Sheet1", 1, 4);
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
			WebElement industry = driver.findElement(By.name("industry"));
			Select s1=new Select(industry);
			s1.selectByVisibleText(industries);
			WebElement types=driver.findElement(By.name("accounttype"));
			Select s2=new Select(types);
			s2.selectByVisibleText(type);
			driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
			WebElement ele = driver.findElement(By.xpath("//span[@class='dvHeaderText']"));
			String text = ele.getText();
			if(text.contains(orgName))
			{
				System.out.println("organization is created===>pass");
			}else{
				System.out.println("organization is not created===>fail");
			}
			driver.close();
		}

}
