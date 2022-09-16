package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtility.webDriverUtility;

public class CreateContactPage 
{
	@FindBy(xpath="//img[@alt='Create Contact...']")
	private WebElement createContactLookUpImg;
	//initilaization
	public CreateContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	

	public WebElement getCreateContactLookUpImg() {
		return createContactLookUpImg;
	}


	/**
	 * This method will click on create new contact look up image
	 */
	public void clickOnCreateContactLookUpImg()
	{
		createContactLookUpImg.click();
		
	}
	
    
}
