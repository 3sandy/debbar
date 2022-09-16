package vtiger.OrganisationTest;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import vtiger.GenericUtility.BaseClass;
import vtiger.ObjectRepository.CreateNewOrganizationPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.OrganisationPage;
import vtiger.ObjectRepository.OrganizationInfoPage;

public class CreateOrganisationTesting extends BaseClass{
	@Test
	public void createOrgnisationTesting() throws IOException
	{
		String orgName = eUtil.readDataFromExcel("Organization", 1, 2)+JUtil.getRandomNumber();
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
	}
}
