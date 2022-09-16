package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtility.webDriverUtility;

public class HomePage extends webDriverUtility
{
	//declaration
	@FindBy(linkText="Organizations")
	private WebElement OrganizationsLnk;
	@FindBy(linkText="Contacts")
	private WebElement ContactsLnk;
	@FindBy(linkText="Opportunities")
	private WebElement OpportunitiesLnk;
	@FindBy(linkText="Products")
	private WebElement ProductsLnk;
	@FindBy(linkText="Leads")
	private WebElement LeadsLnk;
	@FindBy(xpath="//img[@src='themes/softed/images/info.PNG']")
	private WebElement adminstratorimg;
	@FindBy(xpath="//a[@href='index.php?module=Users&action=Logout']")
	private WebElement signOutLnk;
	@FindBy(xpath="//a[@onchange='QCreate(this);']")
	private WebElement QuickcreateImg;
	@FindBy(linkText="More")
	private WebElement MoreLnk;
	@FindBy(linkText="Vendors")
	private WebElement VendorLnk;

	
	
	//initialization
	public WebElement getVendorLnk() {
		return VendorLnk;
	}
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
public WebElement getQuickcreateImg() {
		return QuickcreateImg;
	}
	//utilization
	public WebElement getOrganizationsLnk() {
		return OrganizationsLnk;
	}
	public void setOrganizationsLnk(WebElement organizationsLnk) {
		OrganizationsLnk = organizationsLnk;
	}
	public WebElement getContactsLnk() {
		return ContactsLnk;
	}
	public void setContactsLnk(WebElement contactsLnk) {
		ContactsLnk = contactsLnk;
	}
	public WebElement getOpportunitiesLnk() {
		return OpportunitiesLnk;
	}
	
	public WebElement getProductsLnk() {
		return ProductsLnk;
	}
	
	public WebElement getLeadsLnk() {
		return LeadsLnk;
	}
	
	public WebElement getAdminstratorimg() {
		return adminstratorimg;
	}
	
	public WebElement getSignOutLnk() {
		return signOutLnk;
	}
	
	public WebElement getMoreLnk() {
		return MoreLnk;
	}

	//Business Library
	/**
	 * This method will perform signout operation
	 * @param driver
	 */
	public void signoutofApp(WebDriver driver)
	{
		mouseHoverOn(driver,adminstratorimg);
		signOutLnk.click();
		
	}
	/**
	 * This method will click on organisation
	 */

public void clickonOrgLink()
{
	OrganizationsLnk.click();
}
/**
 * This method will click on contacts
 */
public void clickOnContactsLnk()
{
	ContactsLnk.click();
}



public void clickonquickCreateImg()
{
	QuickcreateImg.click();
}
public void clickOnproductLnk(WebDriver driver)
{
	mouseHoverOn( driver, MoreLnk);
	VendorLnk.click();
}
}


