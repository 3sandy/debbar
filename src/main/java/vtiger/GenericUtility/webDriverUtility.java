package vtiger.GenericUtility;


		import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
		import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

		/**
		 * This class contains all the generic methods related to webdriver action
		 * @author Pawan
		 *
		 */
		public class webDriverUtility {
			/**
			 * This method is used to maximize the window
			 * @param driver
			 */
			public void maximizeWindow(WebDriver driver)
			{
				driver.manage().window().maximize();
			}
			/**
			 * this method will wait for 20 seconds for the entire DOM structure to load
			 * @param driver
			 */

			public void waitForElementsToLoadInDOM(WebDriver driver)
			{
				driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			}
			/**
			 * this method will wait for the particular element to perform click operation
			 * if the element is not interactive it will wait for 1 second
			 * @param element
			 * @throws InterruptedException 
			 * 
			 */
			public void waitForElementToLoad(WebDriver driver,WebElement element)
			{
				WebDriverWait wait=new WebDriverWait(driver,20);
				wait.until(ExpectedConditions.visibilityOf(element));
			}
			public void waitForElementToBeClickable(WebDriver driver,WebElement element)
			{
				WebDriverWait wait=new WebDriverWait(driver,20);
				wait.until(ExpectedConditions.elementToBeClickable(element));

			}

			public void customWaitAndClickOnElement(WebElement element) throws InterruptedException
			
			{
				int count=0;
				while(count<10)
				{
					try
					{
						element.click();
						break;
					}
					catch(Exception e)
					{
						Thread.sleep(1000);
						count++;
				}}}
			/**
			 * This method will handle drop down by select class using index
			 * @param element
			 * @param index
			 */
				public void handleDropDown(WebElement element ,int index)
				{
					Select s=new Select(element);
					s.selectByIndex(index);
				}
				/**
				 * This method will handle the drop down by select class using visible text
				 * @param element
				 * @param visibleText
				 */
				public void handleDropDown(WebElement element,String visibleText)
				{
					Select s=new Select(element);
					s.selectByVisibleText(visibleText);
				}
				/**
				 * This method will handle the drop down by select class using value
				 * @param value
				 * @param element
				 */
				public void handleDropDown(String value,WebElement element)
				{
					Select s=new Select(element);
					s.selectByValue(value);
				}
				/**
				 * This method will perform double click on page
				 * @param driver
				 */
				public void doubleClickOn(WebDriver driver)
				{
					Actions act=new Actions(driver);
					act.doubleClick().perform();
					
				}
				/**
				 * This method will perform double click over a particular element
				 * @param driver
				 * @param element
				 */
				public void doubleClickOn(WebDriver driver,WebElement element)
				{
					Actions act=new Actions(driver);
					act.doubleClick(element).perform();
					
				}
				/**
				 * This method will perfrom mouse hover action on a particular element
				 * @param driver
				 * @param element
				 */
				public void mouseHoverOn(WebDriver driver,WebElement element)
				{
					Actions act=new Actions(driver);
                    act.moveToElement(element).perform();					
				}
				
				/**
				 * This method will perform double click over a particular element
				 * @param driver
				 * @param x
				 * @param y
				 */
				
				public void mouseHoverOn(WebDriver driver,int x, int y)
				{
					Actions act=new Actions(driver);
                    act.moveByOffset(x,y).perform();					
				}
				/**
				 * This method will perform right click action on the particular element 
				 * @param driver
				 * 
				 */
				
				public void rightClickOn(WebDriver driver)
				{
					Actions act=new Actions(driver);
                  act.contextClick().perform();
                     }
				/**
				 * This method will perform right click action on the particular element 
				 * @param driver
				 * @param element
				 */
				public void rightClickOn(WebDriver driver,WebElement element)
				{
					Actions act=new Actions(driver);
                  act.contextClick(element).perform();
                   }
				/**
				 * this method will perform drag and drop action from src element to target element
				 * @param driver
				 * @param srcElement
				 * @param targetElement
				 * 
				 */
				public void dragAndDropOn(WebDriver driver,WebElement srcElement,WebElement targetElement)
				{
					Actions act=new Actions(driver);
					act.dragAndDrop(srcElement,targetElement).perform();
				}
				/**
				 * this method will accept the alert popup
				 * @param driver
				 */
		public void acceptAlert(WebDriver driver)
		{
			driver.switchTo().alert().accept();
		}
/**
 * this method will dismiss the alert
 * @param driver
 */
		public void dismissAlert(WebDriver driver)
		{
			driver.switchTo().alert().dismiss();
		}
		/**
		 * This method will get the text from alert popup and return it to caller
		 * @param driver
		 * @return
		 */
		public String getTextInAlert(WebDriver driver)
		{
			String alertText=driver.switchTo().alert().getText();
			return alertText;
		}
		/**
		 * this method will switch to the window with respect to the window title
		 * @param driver
		 * @param partialTitle
		 * 
		 */
		public void switchToWindow(WebDriver driver,String partialTitle)
		{
			//step-1: get all window handles
			Set<String> windowIds=driver.getWindowHandles();
			
			//step-2: iterate thru all the windowIds
			Iterator<String> it=windowIds.iterator();
			//step-3:navigate inside the windows
			while(it.hasNext())
			{
				//capture all the windows ids
				String winId=it.next();
				//switch to the window and capture the title
				String currentTitle=driver.switchTo().window(winId).getTitle();
				if(currentTitle.contains(partialTitle))
				{
					break;
				}
			}
			
				}
		/**
		 * switch to frame based on Index
		 * @param index
		 * @param driver
		 * 
		 */
		public void switchToFrame(WebDriver driver,int index)
		{
			driver.switchTo().frame(index);
		}
		/**
		 * Switch to frame based on name or id
		 * @param driver
		 * @param idorName
		 * 
		 * 		 */
		public void switchToFrame(WebDriver driver,String idorName)
		{
			driver.switchTo().frame(idorName);
		}
		/**
		 * Switch to frame based on name or id
		 * @param driver
		 * @param element
		 * 
		 * 		
		 */
		public void switchToFrame(WebDriver driver,WebElement element)
		{
			driver.switchTo().frame(element);
		}
		
		/**
		 * Switch to frame based on name or id
		 * @param driver
		 * @param element
		 * @throws IOException 
		 * 
		 * 		
		 */
		public String takeScreenShot(WebDriver driver,String screenShotName) throws IOException
		{
	TakesScreenshot ts=(TakesScreenshot)driver;
	File src=ts.getScreenshotAs(OutputType.FILE);
	String path=".\\Screenshots\\"+screenShotName+".png";
	File dst=new File(path);
	FileUtils.copyFile(src,dst);
	return dst.getAbsolutePath();//used for reporting listeners
		}
		/**
		 * this method will scrool until the particular element
		 * @param driver
		 * @param element
		 * 
		 *
		 */
		public void scrollAction(WebDriver driver,WebElement element)
		{
			JavascriptExecutor js=(JavascriptExecutor)driver;
			//js.executeScript("argument[0].scrollIntoView()",element);
			int y=element.getLocation().getY();
			js.executeScript("window.scrollBy(0,"+y+")",element);
			
		}
		
		
	}


