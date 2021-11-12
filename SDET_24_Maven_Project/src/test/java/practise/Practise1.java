package practise;

import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Practise1 {
   @Test(dataProvider="getSrc_Dst")
   public void bookTicket(String src,String dst)
   {
	   Reporter.log("Book ticket from "+src+" to "+dst+"", true);
   }
   @DataProvider
   public Object[][] getSrc_Dst()
   {
	   Object[][] arr=new Object[5][2];
	   arr[0][0]="Bengaluru";
	   arr[0][1]="Mumbai";
	   arr[1][0]="Chennai";
	   arr[1][1]="Delhi";
	   arr[2][0]="Mysore";
	   arr[2][1]="Hyderabad";
	   arr[3][0]="Kolar";
	   arr[3][1]="Patna";
	   arr[4][0]="Goa";
	   arr[4][1]="Bengaluru";
	return arr;
   }
}


