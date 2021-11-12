package com.Vtiger.genericutilities;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

/**
 * 
 * @author Muniraju
 *
 */

public class WebDriverUtility {
	
	/**
	 *  accepts the address of the application/page(implicitly wait)
	 * @param driver
	 */
	
   public void waitUntilPageLoad(WebDriver driver)
   {
	   driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
   }
   
   /**
    * This method wait for the element to be visible
    * @param driver
    * @param element
    */
   public void waitForElementVisibility(WebDriver driver,WebElement element)
   {
	   WebDriverWait wait=new WebDriverWait(driver, 20);
	   wait.until(ExpectedConditions.visibilityOf(element));
   }
   
   /**
    * This method wait for the element to be clicked , its custom wait created to avoid elemenInterAceptable Exception
    * @param element
    * @throws InterruptedException
    */
   public void waitAndClick(WebElement element) throws InterruptedException
   {
	   int count=0;
	   while(count<20){
		   try{
			   element.click();
			   break;
		   }catch(Exception e){
			   Thread.sleep(1000);
			   count++;
		   }
	   }
   }
   
   /**
    * this methods enables user to handle dropdown(Select tag) using visible text
    * @param element
    * @param option
    */
   public void select(WebElement element, String option)
   {
	   Select s=new Select(element);
	   s.selectByVisibleText(option);
   }
   
   /**
    * this methods enables user to handle dropdown(Select tag) using index
    * @param element
    * @param index
    */
   public void select(WebElement element, int index)
   {
	   Select s=new Select(element);
	   s.selectByIndex(index);
   }
   
   /**
    * This method will perform mouse over action
    * @param driver
    * @param element
    */
   public void mouseHover(WebDriver driver,WebElement element)
   {
	   Actions act=new Actions(driver);
	   act.moveToElement(element).perform();
   }
   
   /**
    * This method will perform right click 
    * @param driver
    * @param element
    */
   public void rightClick(WebDriver driver,WebElement element)
   {
	   Actions act=new Actions(driver);
	   act.contextClick(element).perform();
   }
   
   /**
    * This method helps to switch from one window to another
    * @param driver
    * @param partialWinTitle
    */
   public void switchToWindow(WebDriver driver,String partialWinTitle)
   {
	   Set<String> set = driver.getWindowHandles();
	   Iterator<String> it=set.iterator();
	   while(it.hasNext())
	   {
		   String windowid = it.next();
		   String title = driver.switchTo().window(windowid).getTitle();
		   if(title.contains(partialWinTitle))
		   {
			   break;
		   }
	   }
   }
   
   /**
    * Accept alert 
    * @param driver
    */
   public void acceptAlert(WebDriver driver)
   {
	   driver.switchTo().alert().accept();
   }
   
   /**
    * Dismiss alert
    * @param driver
    */
   public void dismissAlert(WebDriver driver)
   {
	   driver.switchTo().alert().dismiss();
   }
   
   /**
    * This method used for scrolling action in a webpage
    * @param driver
    * @param element
    */
   public void scrollToWebElement(WebDriver driver,WebElement element)
   {
	   JavascriptExecutor js=(JavascriptExecutor) driver;
	   int y=element.getLocation().getY();
	   js.executeScript("window.scrollBy(0,"+y+")");
   }
   
   /**
    * This method used to switch from one frame to another frame based on index
    * @param driver
    * @param index
    */
   public void switchFrame(WebDriver driver,int index) {
   	driver.switchTo().frame(index);
   }   

   /**
    * This method used to switch from one frame to another frame based on element
    * @param driver
    * @param element
    */
   public void switchFrame(WebDriver driver,WebElement element) {
   	driver.switchTo().frame(element);
   } 
	
   /**
    * This method used to switch from one frame to another frame based on id
    * @param driver
    * @param idOrName
    */
   public void switchFrame(WebDriver driver,String idOrName) {
   	driver.switchTo().frame(idOrName);
   } 

   /**
    * This method will take screenshot
    * @param driver
    * @param screenshotName
    * @throws IOException
    */
   public void takeScreenshot(WebDriver driver,String screenshotName) throws IOException
   {
	   TakesScreenshot ts=(TakesScreenshot) driver;
	  File src=ts.getScreenshotAs(OutputType.FILE);
	  File dst=new File("./screenshot/"+screenshotName+".PNG");
	  Files.copy(src, dst);
   }
   
   /**
    * pass enter Key appertain in to Browser
    * @param driver
    */
  public void passEnterKey(WebDriver driver) {
	   Actions act = new Actions(driver);
	   act.sendKeys(Keys.ENTER).perform();
  } 

}
