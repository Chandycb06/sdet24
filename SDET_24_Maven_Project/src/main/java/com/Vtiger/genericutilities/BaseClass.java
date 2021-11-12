package com.Vtiger.genericutilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.crm.vtiger.objectrepositorylib.Homepage;
import com.crm.vtiger.objectrepositorylib.Loginpage;

public class BaseClass {
	public FileUtility fui=new FileUtility();
	public JavaUtility ju=new JavaUtility();
	public ExcelUtility eu=new ExcelUtility();
	public WebDriverUtility wu=new WebDriverUtility();
	public WebDriver driver=null;
	public DatabaseUtility dbu=new DatabaseUtility();
	
	@BeforeSuite(groups={"smokeTest","regressionTest"})
	public void configBS()
	{
		System.out.println("===connect to Database===");
		//dbu.connectToDB();
	}
	
	@Parameters(value="BROWSER")
	@BeforeClass(groups={"smokeTest","regressionTest"})
	public void configBC(String BROWSER) throws Exception
	{
		System.out.println("===launch the browser===");
     	//String BROWSER =fui.getPropertyKeyValue("browser");
     	
 		if(BROWSER.equals("firefox")){
 			driver=new FirefoxDriver();
 		}else if(BROWSER.equals("chrome")){
 			driver=new ChromeDriver();
 		}
	}
	
	@BeforeMethod(groups={"smokeTest","regressionTest"})
	public void configBM() throws Exception
	{
		System.out.println("===Login to application===");
 		Loginpage lp=new Loginpage(driver);
 		lp.loginToAppln();
	}
	
	@AfterMethod(groups={"smokeTest","regressionTest"})
	public void configAM()
	{
		System.out.println("===Logout of application");
		Homepage hp=new Homepage(driver);
		hp.logOutAppln();
	}
	
	@AfterClass(groups={"smokeTest","regressionTest"})
	public void configAC()
	{
		System.out.println("===close the browser===");
		driver.quit();
	}
	
	@AfterSuite(groups={"smokeTest","regressionTest"})
	public void configAS() throws Exception
	{
		System.out.println("===close the database connection===");
		//dbu.closeDB();
	}
	
}
