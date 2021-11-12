package com.Vtiger.genericutilities;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Date;
import java.util.Random;
/**
 * 
 * @author Muniraju
 *
 */
public class JavaUtility {
	/**
	 * returns the random integer number in the form of String 
	 * @return
	 */
   public String getRandomNum()
   {
	   Random ran=new Random();
	   int randnum=ran.nextInt(1000);
	   return "_"+randnum;
   }
   
   /**
    * returns the current date in the form of String
    * @return
    */
   public String getDate()
   {
	   Date dat=new Date();
	   String date1=dat.toString();
	   String date=date1.replaceAll(":", "-");
	   return date;
   }
   
   /**
    * used to pass virtual key(Enter)
    * @throws Throwable
    */
   public void pressVurtualEnterKey() throws Throwable {
   	
   	Robot rc=new Robot();
   	rc.keyPress(KeyEvent.VK_ENTER);
   	rc.keyRelease(KeyEvent.VK_ENTER);
   }

}
