package vtiger.ContactsTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.GenericUtility.ExcelFileUtility;
import vtiger.GenericUtility.PropertyFileUtility;
import vtiger.GenericUtility.javaUtility;
import vtiger.GenericUtility.webDriverUtility;
import vtiger.ObjectRepository.CreateNewOrganizationPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.LoginPage;
import vtiger.ObjectRepository.OrganisationPage;
import vtiger.ObjectRepository.OrganizationInfoPage;

/**
 * 
 * @author Pawan
 *
 */
public class CreateMultipleOrganisationWithIndustryTest {
	// TODO Auto-generated method stub
				javaUtility jUtil=new javaUtility();
				ExcelFileUtility eUtil=new ExcelFileUtility();
				webDriverUtility wUtil=new webDriverUtility();
				PropertyFileUtility pUtil=new PropertyFileUtility();
				WebDriver driver;
	
		
		@Test(dataProvider="OrgData")
		public void createMultipleOrgTest(String OrgName,String industryType) throws IOException
		{
			
			
			//read all the necessary data
			String BROWSER=pUtil.readDataFromPropertyFile("browser");
			String URL=pUtil.readDataFromPropertyFile("url");
			String USERNAME=pUtil.readDataFromPropertyFile("username");
			String PASSWORD=pUtil.readDataFromPropertyFile("password");
			
			String Org=OrgName+jUtil.getRandomNumber();
			//launch the browser
			 if(BROWSER.equalsIgnoreCase("CHROME"))
			    {
			    	WebDriverManager.chromedriver().setup();
			    	driver = new ChromeDriver();
			    	System.out.println("chrome browser launched");
			    	
			    }
			    else if(BROWSER.equalsIgnoreCase("FIREFOX"))
			    {
			    	WebDriverManager.firefoxdriver().setup();
			    	driver = new FirefoxDriver();
			    	System.out.println("firefox browser launched");

			    }
			    else
			    {
			    	System.out.println("invalid browesr name");
			    }
			    wUtil.maximizeWindow(driver);
			    wUtil.waitForElementsToLoadInDOM(driver);
			    driver.get(URL);

			    //login to app
			    LoginPage lp=new LoginPage(driver);
			    lp.loginToApp(USERNAME, PASSWORD);
			    
			    //Navigate to Organisation link
			    HomePage hp=new HomePage(driver);
			    hp.clickonOrgLink();
			    
			    //Navigate to create org look up image
			    OrganisationPage op=new OrganisationPage(driver);
			    op.clickOnCreateNewOrgImg();
			    
			    //create new org with industry type
			    CreateNewOrganizationPage cop=new CreateNewOrganizationPage(driver);
			    cop.createNewOrg(OrgName+jUtil.getRandomNumber(), industryType);
			    
			    //validate
			    OrganizationInfoPage oip=new OrganizationInfoPage(driver);
			    String orgHeader=oip.getOrgHeader();
			    System.out.println(orgHeader);
			    if(orgHeader.contains(Org))
			    {
			    	
			  System.out.println("PASS");
			    }
			    else 
			    {
					  System.out.println("FAIL");
			    	
			    }
			  	}
		
@DataProvider(name="OrgData")
public Object[][] getData() throws EncryptedDocumentException, IOException
{
	return eUtil.readMultipeDataFromExcel("Multipleorg");
}
}
