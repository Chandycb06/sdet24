package com.vtiger.createContactTest;


import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.vtiger.objectrepositorylib.ContactInfoPage;
import com.crm.vtiger.objectrepositorylib.Contactspage;
import com.crm.vtiger.objectrepositorylib.CreateContactpage;
import com.crm.vtiger.objectrepositorylib.CreateOrganizationsPage;
import com.crm.vtiger.objectrepositorylib.Homepage;
import com.crm.vtiger.objectrepositorylib.OrganizationsInfoPage;
import com.crm.vtiger.objectrepositorylib.Organizationspage;
import com.Vtiger.genericutilities.BaseClass;

public class CreateContactTest extends BaseClass {
	 @Test
     public void createContact()throws Exception
     {	
 	  	//Initialize the variables
     	String lastName=eu.getData("Contact", 1, 3)+"_"+ju.getRandomNum();
 
 		//Navigate to Contacts 
 		Homepage hp=new Homepage(driver);
 		hp.getContactsTab().click();
 		
 		//click on create contact in contacts page
 		 Contactspage cp= new Contactspage(driver);
  	    cp.getCreateContactButton().click();
  	    
  	      
  	    //Enter the lastname and perform click on action on lookup
  	    CreateContactpage ccp=new CreateContactpage(driver);
  	    ccp.getLastNametxtfd().sendKeys(lastName);
  	    ccp.getSaveButton().click();
  	    
  	    //Verify
  	    ContactInfoPage cip=new ContactInfoPage(driver);
  	    if((cip.getConNameVerify().getText()).contains(lastName))
  	    {
  	    	System.out.println(lastName+" is created===>pass");
  	    }else{
  	    	System.out.println(lastName+" is not created===>fail");
  	    }
  	    
     }
	 @Test(groups = "regressionTest")
     public void createContactWithOrg()
     {
    	
     	//Read test data
     	String orgName =eu.getData("Contact", 1, 2)+"_"+ju.getRandomNum();
     	String lastName=eu.getData("Contact", 1, 3)+"_"+ju.getRandomNum();
     	String indName=eu.getData("Sheet1", 1, 3);
     	String typeName=eu.getData("Sheet1", 1, 4);
     	
 		//Navigate to Organizations 
 		Homepage hp=new Homepage(driver);
 		hp.getOrganizationsTab().click();
 		
 		//Navigate to Create Organization 
 		Organizationspage op=new Organizationspage(driver);
 		op.getCreateOrgButton().click();
 		
 		//Create organization
 		CreateOrganizationsPage cop=new CreateOrganizationsPage(driver);
 		cop.createOrganization(driver, orgName, indName, typeName);
 	    
 	    //Verify
 	    OrganizationsInfoPage oip=new OrganizationsInfoPage(driver);
 	    if((oip.getOrgNameVerify().getText()).contains(orgName))
 	    {
 	    	System.out.println("organization is created===>pass");
 	    }else{
 	    	System.err.println("organization is not created===>fail");
 	    }
 	    
 	    //wait for element visiblity
 	    wu.waitForElementVisibility(driver, hp.getContactsTab());
 	    //Navigate to Contacts
 	    hp.getContactsTab().click();
 	    Contactspage cp= new Contactspage(driver);
        
 	    //Navigate to create contact
 	    cp.getCreateContactButton().click();
 	    
 	    //Create a contact
 	    CreateContactpage ccp=new CreateContactpage(driver);
 	    ccp.createContact(driver, lastName, orgName);
 	    
 	    //Verify
 	    ContactInfoPage cip=new ContactInfoPage(driver);
 	    if((cip.getConNameVerify().getText()).contains(lastName))
 	    {
 	    	System.out.println(lastName+" is created===>pass");
 	    }else{
 	    	System.out.println(lastName+" is not created===>fail");
 	    }
 	    
     }
}
