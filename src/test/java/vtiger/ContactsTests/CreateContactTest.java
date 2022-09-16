package vtiger.ContactsTests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
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
import vtiger.ObjectRepository.OrganisationPage;

/**
 * This contains test script to create contact
 * @author Pawan
 *
 */
public class CreateContactTest extends BaseClass {
@Test(groups="RegressionSuite")
	public  void createContactTest() throws IOException 
	{
		
				String LASTNAME=eUtil.readDataFromExcel("Contacts",1,2)+JUtil.getRandomNumber()	;
				 //Navigate to Contacts link
				HomePage hp = new HomePage(driver);
			    hp.clickOnContactsLnk();
			    Reporter.log("Contacts link clicked",true);

			    
			    //Navigate to create contcts img
			    CreateContactPage sp=new CreateContactPage(driver);
			    sp.clickOnCreateContactLookUpImg();
			    Reporter.log("Create Contact Look up img created",true);

			  //Create contact with org details
			    CreatNewContactPage cnp = new CreatNewContactPage(driver);
			    cnp.creatNewContact(LASTNAME);
			    Reporter.log("new Contact with lastname created",true);
			    
			  //Validate
			    ContactsInfoPage cip = new ContactsInfoPage(driver);
			    String contactHeader = cip.getConHeader();
			    System.out.println(contactHeader);
			   Assert.assertTrue(contactHeader.contains(LASTNAME));
			    
			    
			    
			  
	}

	
}
