
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

public class ApptimizeLogin {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver" , "usr/local/bin/chromedriver");
		
		driver.get("https://apptimize.com");
		System.out.println(driver.getTitle());
		
		//Create Free trial account
		
		driver.findElement(By.xpath("//a[@class='btn navbar__btn-register']")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(By.id("eula"))).click().build().perform();
		
		
		driver.findElement(By.xpath("//input[@id='fname']")).sendKeys("sanem1");
		driver.findElement(By.xpath("//input[@id='lname']")).sendKeys("test1");
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("apptimizetestuser18@gmail.com");
		driver.findElement(By.xpath("//input[@id='company']")).sendKeys("Apptimize Candidate");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("qatest1234");
		
		
		System.out.println(driver.findElement(By.xpath("//input[@id='eula']")).isSelected());
		
		System.out.println(driver.findElement(By.id("signup-text")).isDisplayed());
		
		driver.findElement(By.xpath("//a[@class='optanon-allow-all']")).click();
		
		System.out.println(driver.findElement(By.id("signup-text")).isDisplayed());
		Actions actions2 = new Actions(driver);
		actions2.moveToElement(driver.findElement(By.id("signup-text"))).click().build().perform();
		WebDriverWait wait2 = new WebDriverWait(driver, 10);
		wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='signup-text']")));
		driver.findElement(By.xpath("//div[@id='signup-text']")).click();
		System.out.println("if tests fails here, please make sure email address has not been used to create account");
		
		//Create first app
		WebDriverWait wait3 = new WebDriverWait(driver, 10);
		wait3.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='zet-app-name']")));
		driver.findElement(By.xpath("//input[@id='zet-app-name']")).sendKeys("myfirstapp");
		driver.findElement(By.xpath("//li[@id='zet-icon-ios']")).click();
		driver.findElement(By.xpath("//button[@id='zet-create-app']")).click();
		
		//Logout
		driver.findElement(By.xpath("//span[@class='ng-binding']")).click();
		WebDriverWait wait4 = new WebDriverWait(driver, 10);
		wait4.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='zet-navbar-signout']")));
		driver.findElement(By.xpath("//a[@id='zet-navbar-signout']")).click();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.close();
		
		
		
		
		
	}

}
