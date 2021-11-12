package com.Vtiger.genericutilities;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * 
 * @author Muniraju
 *
 */
public class FileUtility {
	
	/**
	 *  used to get the data from properties File based on key
	 * @param key
	 * @return the value of the key is in the form of String
	 * @throws Exception
	 */
   public String getPropertyKeyValue(String key)throws Exception
   {
	   FileInputStream fis=new FileInputStream("./Data/CommonData.properties");
	   Properties pObj=new Properties();
	   pObj.load(fis);
	   String value = pObj.getProperty(key);
	   return value;
   }
}
