package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtility.webDriverUtility;

public class OrganizationInfoPage extends webDriverUtility
{
	//declaration
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement OrgHeaderText;


//initialize
public OrganizationInfoPage (WebDriver driver)
{
	PageFactory.initElements(driver,this);
}
public WebElement getOrgHeaderText() {
	return OrgHeaderText;
}
/**
 * This method will get the header text for organisation
 * @return
 */
public String getOrgHeader()
{
	String orgHeader=OrgHeaderText.getText();
	return orgHeader;
}
}