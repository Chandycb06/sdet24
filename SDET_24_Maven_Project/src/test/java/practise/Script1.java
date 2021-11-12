package practise;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;



public class Script1 {
    @Test
    public void rmg()throws Exception
    {
    	WebDriver driver=new FirefoxDriver();
    	driver.manage().window().maximize();
    	driver.findElement(By.xpath("//input[@id='usernmae']")).sendKeys("rmgyantra");
    	driver.findElement(By.xpath("//input[@type='password']")).sendKeys("rmgy@9999");
    	driver.findElement(By.xpath("//button[@type='submit']")).click();
    	driver.findElement(By.xpath("//a[.='Projects']")).click();
    	driver.findElement(By.xpath("//span[.='Create Project']")).click();
    	driver.findElement(By.xpath("//input[@name='projectName']")).sendKeys("RMGsde");
    	driver.findElement(By.xpath("//input[@name='createdBy']")).sendKeys("Muniraju");
    	WebElement ele = driver.findElement(By.xpath("(//select[@name='status'])[2]"));
    	Select s=new Select(ele);
    	s.selectByVisibleText("Created");
    	driver.findElement(By.xpath("//input[@type='submit']")).click();
    	//
    	Driver driverref=new Driver();
    	DriverManager.registerDriver(driverref);
    	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
    	Statement stat = con.createStatement();
    	ResultSet set = stat.executeQuery("select * from project");
    	while(set.next()){
    		if((set.getString(4)).equals("RMGsde")){
    			System.out.println("project is created");
    		}else{
    			System.err.println("project is not created");
    		}
    	}
    	con.close();
    }
}
