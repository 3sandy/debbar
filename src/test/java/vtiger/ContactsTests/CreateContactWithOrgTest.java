package vtiger.ContactsTests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
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

public class CreateContactWithOrgTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
WebDriver driver = null;
		
		//Create object of utilities
		javaUtility jUtil = new javaUtility();
		PropertyFileUtility pUtil = new PropertyFileUtility();
		ExcelFileUtility eUtil = new ExcelFileUtility();
		webDriverUtility wUtil = new webDriverUtility();
		
		//Read all the requird data
		String BROWSER = pUtil.readDataFromPropertyFile("browser");
		String URL = pUtil.readDataFromPropertyFile("url");
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSOWRD = pUtil.readDataFromPropertyFile("password");
		
		String orgName = eUtil.readDataFromExcel("Contacts", 3, 2)+jUtil.getRandomNumber();
	    String lastname = eUtil.readDataFromExcel("Contacts", 3, 3);
	    	
	    //Launch browser
	    if(BROWSER.equalsIgnoreCase("CHROME"))
	    {
	    	WebDriverManager.chromedriver().setup();
	    	driver = new ChromeDriver();
	    }
	    else if(BROWSER.equalsIgnoreCase("FIREFOX"))
	    {
	    	WebDriverManager.firefoxdriver().setup();
	    	driver = new FirefoxDriver();
	    }
	    else
	    {
	    	System.out.println("invalid browesr name");
	    }
	    wUtil.maximizeWindow(driver);
	    wUtil.waitForElementsToLoadInDOM(driver);
	    driver.get(URL);

	    //login To APP
	    LoginPage lp = new LoginPage(driver);
	    lp.loginToApp(USERNAME, PASSOWRD);
	    
	    //Navigate to Organizations link
	    HomePage hp = new HomePage(driver);
	    hp.clickonOrgLink();
	    
	    //Navigate to create Org img
	    OrganisationPage op = new OrganisationPage(driver);
	    op.clickOnCreateNewOrgImg();
	    
	    // Create Organization with mandatory fields
	    CreateNewOrganizationPage cop = new CreateNewOrganizationPage(driver);
	    cop.createNewOrg(orgName);
	    
	  //Validate
	    OrganizationInfoPage oip = new OrganizationInfoPage(driver);
	    String OrgHeader = oip.getOrgHeader();
	    System.out.println(OrgHeader);
	    if(OrgHeader.contains(orgName))
	    {
	    	System.out.println("Org created");
	    }
	    else
	    {
	    	System.out.println("Org not created");
	    }
	  //Navigate to Contacts link
	    
	    hp.clickOnContactsLnk();
	    
	    
	    //Navigate to create contcts img
	    CreateContactPage sp=new CreateContactPage(driver);
	    sp.clickOnCreateContactLookUpImg();
	    
	  //Create contact with org details
	    CreatNewContactPage cnp = new CreatNewContactPage(driver);
	   cnp.creatNewContact(lastname, orgName, driver);
	   //Validate
	    ContactsInfoPage cip = new ContactsInfoPage(driver);
	    String contactHeader = cip.getConHeader();
	    System.out.println(contactHeader);
	    if(contactHeader.contains(lastname))
	    {
	    	System.out.println("PASS");
	    }
	    else
	    {
	    	System.out.println("FAIL");
	    }
	    
	    //Sign out

	}

}
