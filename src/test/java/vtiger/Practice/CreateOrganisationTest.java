package vtiger.Practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreateOrganisationTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//step 1:Launch the browser
WebDriver driver=new FirefoxDriver();
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
driver.get("httP://localhost:8888");

//step 2:-login the app
driver.findElement(By.name("user_name")).sendKeys("admin");
driver.findElement(By.name("user_password")).sendKeys("admin");
driver.findElement(By.id("submitButton")).click();

//step-3:-navigate to organisation link
driver.findElement(By.linkText("Organizations")).click();
//step-4:-
driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys("lambo");
driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

driver.close();
System.out.println("org created");
	




	}

}
