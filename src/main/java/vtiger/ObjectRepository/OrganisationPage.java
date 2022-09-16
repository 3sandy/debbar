package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtility.webDriverUtility;

public class OrganisationPage 

{
//declaration
	@FindBy(xpath="//img[@alt='Create Organization...']")
			private WebElement createNewOrgLookUpImg;
	//initilaization
	public OrganisationPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	public WebElement getCreateNewOrgLookUpImg() {
		return createNewOrgLookUpImg;
	}
	/**
	 * This method will click on creat new organisation look up image
	 */
	public void clickOnCreateNewOrgImg()
	{
		createNewOrgLookUpImg.click();
	}
}
