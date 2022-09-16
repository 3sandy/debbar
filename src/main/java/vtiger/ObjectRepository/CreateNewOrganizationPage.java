package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtility.webDriverUtility;

public class CreateNewOrganizationPage extends webDriverUtility {
//declaration
	@FindBy(name="accountname")
	private WebElement OrgNameEdt;
	@FindBy(name="industry")
	private WebElement industryDropDown;
	@FindBy(name="accounttype")
	private WebElement typeDropDown;
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	//initialiation
	public CreateNewOrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	public WebElement getOrgNameEdt() {
		return OrgNameEdt;
	}
	public WebElement getIndustryDropDown() {
		return industryDropDown;
	}
	public WebElement getTypeDropDown() {
		return typeDropDown;
	}
	public WebElement getSaveBtn() {
		return saveBtn;
	}
	//Business library
	/** This method will creat organisation with org name
	 * @param OrgName
	 * 
	 */
	public void createNewOrg(String orgName)
	{
		OrgNameEdt.sendKeys(orgName);
		saveBtn.click();
		
	}
	/**
	 * This method will create organisation with industry drop down
	 * @param Org name
	 * @param Industry Type
	 */
	public void createNewOrg(String OrgName,String industryType)
	{
		OrgNameEdt.sendKeys(OrgName);
		handleDropDown(industryType,industryDropDown);
		saveBtn.click();
	}
/**
 * 	 * This method will create organisation with type and industry drop down
 * @param Org name
* @param Industry Type
 *@param type
 */
	public void createNewOrg(String orgName,String industryType,String type)
	{
		OrgNameEdt.sendKeys(orgName);
		handleDropDown(industryType,industryDropDown);
		handleDropDown(type,typeDropDown);

		saveBtn.click();
	}
	

}
