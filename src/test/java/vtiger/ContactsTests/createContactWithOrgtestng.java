package vtiger.ContactsTests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.GenericUtility.BaseClass;
import vtiger.GenericUtility.ExcelFileUtility;
import vtiger.GenericUtility.PropertyFileUtility;
import vtiger.GenericUtility.javaUtility;
import vtiger.GenericUtility.webDriverUtility;
import vtiger.ObjectRepository.ContactsInfoPage;
import vtiger.ObjectRepository.CreatNewContactPage;
import vtiger.ObjectRepository.CreateContactPage;
import vtiger.ObjectRepository.CreateNewOrganizationPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.LoginPage;
import vtiger.ObjectRepository.OrganisationPage;
import vtiger.ObjectRepository.OrganizationInfoPage;
@Listeners(vtiger.GenericUtility.ListenerImplementation.class)
public class createContactWithOrgtestng extends BaseClass

{
	@Test(groups="SmokeSuite")
	public void createContactWithOrgTest() throws IOException 
	{
		// TODO Auto-generated method stub

				
		String orgName = eUtil.readDataFromExcel("Contacts", 3, 2)+JUtil.getRandomNumber();
	    String lastname = eUtil.readDataFromExcel("Contacts", 3, 3);
	    	
	       
	    //Navigate to Organizations link
	    HomePage hp = new HomePage(driver);
	    hp.clickonOrgLink();
	    Reporter.log("Organisation link clicked,true",true);
	    
	    //Navigate to create Org img
	    OrganisationPage op = new OrganisationPage(driver);
	    op.clickOnCreateNewOrgImg();
	    Reporter.log("create org look up img cliccked",true);

	    
	    // Create Organization with mandatory fields
	    CreateNewOrganizationPage cop = new CreateNewOrganizationPage(driver);
	    cop.createNewOrg(orgName);
	    Reporter.log("New Organization created",true);

	  //Validate
	    OrganizationInfoPage oip = new OrganizationInfoPage(driver);
	    String OrgHeader = oip.getOrgHeader();
	    System.out.println(OrgHeader);
	   Assert.assertEquals(OrgHeader.contains(orgName), true);
	   Assert.fail();
	  //Navigate to Contacts link
	    
	    hp.clickOnContactsLnk();
	    Reporter.log("Contacts link clicked",true);

	    
	    //Navigate to create contcts img
	    CreateContactPage sp=new CreateContactPage(driver);
	    sp.clickOnCreateContactLookUpImg();
	    Reporter.log("Create Contact Look up img created",true);

	    
	  //Create contact with org details
	    CreatNewContactPage cnp = new CreatNewContactPage(driver);
	   cnp.creatNewContact(lastname, orgName, driver);
	    Reporter.log("new Contact with organization created",true);

	   
	   //Validate
	    ContactsInfoPage cip = new ContactsInfoPage(driver);
	    String contactHeader = cip.getConHeader();
	    System.out.println(contactHeader);
	   Assert.assertTrue(contactHeader.contains(lastname));
	}
	@Test
	public void demoRegression()
	{
		System.out.println("This is demo");
	}
}
