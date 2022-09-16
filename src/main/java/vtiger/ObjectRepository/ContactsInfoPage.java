package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsInfoPage {
	//declaration
		@FindBy(xpath="//span[@class='dvHeaderText']")
		private WebElement ConHeaderText;


	//initialize
	public ContactsInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}


	public WebElement getConHeaderText() {
		return ConHeaderText;
	}
	public String getConHeader()
	{
		String contactHeader =ConHeaderText.getText();
		return contactHeader ;
	}
	
}
