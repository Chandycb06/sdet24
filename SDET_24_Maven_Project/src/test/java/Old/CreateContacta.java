package Old;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateContacta {
     
	@Test(retryAnalyzer=com.Vtiger.genericutilities.RetryAnalyser.class)
	public void createOrg()
	{
		System.out.println("Creating organization");
		Assert.fail();
	}
}
