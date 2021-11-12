package Old;

import java.io.FileInputStream;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class NewDataDrivenCmdTest {
    @Test
    public void create()throws Exception
    {
    	String BROWSER = "firefox"; //System.getProperty("browser");
	  	String URL = "http://localhost:8888";//System.getProperty("url");
	  	String USERNAME = "admin";//System.getProperty("username");
	  	String PASSWORD = "admin";//System.getProperty("password");
    	Random random=new Random();
	  	int randomNum = random.nextInt(100);
    	FileInputStream fis=new FileInputStream("./Excel/E1.xlsx");
    	Workbook wb = WorkbookFactory.create(fis);
    	Cell ce = wb.getSheet("Sheet1").getRow(1).getCell(2);
    	String orgname = ce.toString()+"_"+randomNum;
    	
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
		driver.close();
    }
}
