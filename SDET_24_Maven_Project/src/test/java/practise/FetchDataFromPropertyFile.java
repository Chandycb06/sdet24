package practise;

import java.io.FileInputStream;
import java.util.Properties;

public class FetchDataFromPropertyFile {
   public static void main(String[] args)throws Exception {
	FileInputStream fis=new FileInputStream("./Data/CommonData.properties");
	Properties pObj=new Properties();
	pObj.load(fis);
	String BROWSER = pObj.getProperty("browser");
	String URL = pObj.getProperty("url");
	String USERNAME = pObj.getProperty("username");
	String PASSWORD = pObj.getProperty("password");
	
	System.out.println(BROWSER);
	System.out.println(URL);
	System.out.println(USERNAME);
	System.out.println(PASSWORD);
}
}
