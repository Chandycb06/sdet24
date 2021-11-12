package practise1test;

import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Demo {
   public static void main(String[] args)throws Exception {
	   String BROWSER=null;
	   String URL=null;
	   String USERNAME=null;
	   String PASSWORD=null;
	   String ORGNAME=null;
	FileInputStream fis=new FileInputStream("./Excel/E2.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sh = wb.getSheet("Sheet1");
	Row rw = sh.getRow(0);
	for(int i=0;i<rw.getLastCellNum();i++)
	{
		String txt=rw.getCell(i).toString();
		if(txt.equals("browser")){
			BROWSER=sh.getRow(1).getCell(i).toString();
		}else if(txt.equals("url")){
			URL=sh.getRow(1).getCell(i).toString();
		}else if(txt.equals("username")){
			USERNAME=sh.getRow(1).getCell(i).toString();
		}else if(txt.equals("password")){
			PASSWORD=sh.getRow(1).getCell(i).toString();
		}else if(txt.equals("orgName")){
			ORGNAME=sh.getRow(1).getCell(i).toString();
		}
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
	driver.findElement(By.name("accountname")).sendKeys(ORGNAME);
	driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
	WebElement ele = driver.findElement(By.xpath("//span[@class='dvHeaderText']"));
	String text = ele.getText();
	if(text.contains(ORGNAME))
	{
		System.out.println("organization is created===>pass");
	}else{
		System.out.println("organization is not created===>fail");
	}
	driver.close();
}
}
