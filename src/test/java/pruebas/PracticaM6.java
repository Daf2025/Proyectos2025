package pruebas;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PracticaM6 {
	String url= "https://practice.automationtesting.in";
	WebDriver driver;
	
	@BeforeMethod
	public void setUP() {
	
	ChromeOptions options=new ChromeOptions();
	options.addArguments("--incognito");
	//options.addArguments("--headless");
	driver= new ChromeDriver(options);
	driver.get(url);
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	}
	
	@Test
	public void testLogo() {
    WebDriverWait espera=new WebDriverWait(driver,Duration.ofSeconds(20));
	espera.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='Automation Practice Site']")));
	WebElement linkTitulo=driver.findElement(By.xpath("//a[@title='Automation Practice Site']"));
	linkTitulo.click();	
		
	}
	
	@AfterMethod
	public void tearDown() {
	driver.quit();
	}
	
	
}
	
	
