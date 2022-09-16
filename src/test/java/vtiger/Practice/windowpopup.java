package vtiger.Practice;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class windowpopup {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("httP://localhost:8888");

		//step 2:-login the app
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();

		driver.findElement(By.linkText("Contacts")).click();
		//step-4:-
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("uppuluri");
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		Set<String> aalwhs=driver.getWindowHandles();
		String ParentTitle=driver.getTitle();
		for(String wh:aalwhs)
		{
			String title =driver.switchTo().window(wh).getTitle();
			if(!title.equals(ParentTitle))
			{
				driver.findElement(By.linkText("typing")).click();
			}
		}
		

	}

}
