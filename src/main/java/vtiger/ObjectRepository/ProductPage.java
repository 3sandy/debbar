package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage  {
	//declaration
		@FindBy(xpath="//img[@alt='Create Product...']")
				private WebElement createNewProdLookUpImg;
		//initilaization
		public ProductPage(WebDriver driver)
		{
			PageFactory.initElements(driver,this);
		}
		
		public WebElement getCreateNewProdLookUpImg() {
			return createNewProdLookUpImg;
		}

		/**
		 * This method will click on creat new organisation look up image
		 */
		public void clickOnCreateProImg()
		{
			createNewProdLookUpImg.click();
		}
}
