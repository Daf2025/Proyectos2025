package EducacionIT_75402.EduIT;

import java.time.Duration;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class PracticaM2 { 

String url = "http://www.automationpractice.pl/"; 

	
@Test
public void RegistrarEmailFirefox() {
	
	WebDriver driver= new FirefoxDriver();
	
	driver.manage().deleteAllCookies();
	
	driver.manage().window().maximize();
	
	driver.get(url);
	
	WebElement lnkSign=driver.findElement(By.partialLinkText("Sign"));
	lnkSign.click();
	
	WebElement txtEmail=driver.findElement(By.cssSelector("#email_create"));
	txtEmail.sendKeys("correo4feb"+Math.random()+"@gmail.com");
	
    WebElement btnCreate=driver.findElement(By.id("SubmitCreate"));
    btnCreate.click();
    
    WebDriverWait espera=new WebDriverWait(driver,Duration.ofSeconds(1));
    espera.until(ExpectedConditions.elementToBeClickable(By.id("id_gender1")));
    
    WebElement radTitulo=driver.findElement(By.id("id_gender1"));
    radTitulo.click();
    
    WebElement txtNombre=driver.findElement(By.name("customer_firstname"));
    txtNombre.sendKeys("Arturo");
    
    WebElement txtApellido=driver.findElement(By.name("customer_lastname"));
    txtApellido.sendKeys("Carranza");
    
    WebElement txtEmailForm=driver.findElement(By.id("email"));
    txtEmailForm.clear();
    
    txtEmailForm.sendKeys("correModificadoo04feb"+Math.random()+"@gmail.com");
    
    WebElement txtPassword=driver.findElement(By.name("passwd"));
    txtPassword.sendKeys("123477");

    Select drpDaysForm=new Select(driver.findElement(By.id("days")));
    drpDaysForm.selectByValue("11");
    
    Select drpMonthsForm=new Select(driver.findElement(By.id("months")));
    drpMonthsForm.selectByValue("4");
    
    Select drpYearsForm=new Select(driver.findElement(By.id("years")));
    drpYearsForm.selectByValue("1980");
    
    WebElement chkNewsletter=driver.findElement(By.name("newsletter"));
    chkNewsletter.click();
    	
    WebElement btnRegister=driver.findElement(By.id("submitAccount"));
    btnRegister.click();
    
    driver.quit();
 }
}