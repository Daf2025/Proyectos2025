package EducacionIT_75402.EduIT;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

public class PracticaM3 {

    WebDriver driver;
    String url = "http://www.automationpractice.pl/";
    String urlAuthentication = "http://www.automationpractice.pl/index.php?controller=my-account";

    @BeforeSuite
    public void setUP() {
        driver = new FirefoxDriver();
    }

    @BeforeTest
    public void irUrl() {
        driver.get(url);
    }

    @BeforeClass
    public void maxVentana() {
        driver.manage().window().maximize();
    }

    @Test
	public void registrarUsuario() {
		
		WebElement lnkSign=driver.findElement(By.partialLinkText("Sign"));
		lnkSign.click();
		
		WebElement txtEmail=driver.findElement(By.cssSelector("#email_create"));
		txtEmail.sendKeys("correo4feb"+Math.random()+"@gmail.com");
		
	    WebElement btnCreate=driver.findElement(By.id("SubmitCreate"));
	    btnCreate.click();
	    
	    WebDriverWait espera=new WebDriverWait(driver,Duration.ofSeconds(20));
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
	    
	    System.out.print("Resultado esperado:" + urlAuthentication);
	    System.out.println("------------------------------------------------------------------------------------------------------------");
	    System.out.print("Resultado obtenido:" + driver.getCurrentUrl());
	    System.out.println("------------------------------------------------------------------------------------------------------------");

        Assert.assertEquals(driver.getCurrentUrl(), urlAuthentication);
    }
    
    @AfterMethod
    public void CapturaPantalla() throws IOException {
        File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File carpeta = new File("..\\EduIT\\Evidencias");
        if (!carpeta.exists()) carpeta.mkdirs();
        FileUtils.copyFile(screen, new File(carpeta, "pantalla_" + System.currentTimeMillis() + ".png"));
    }

	@AfterClass
	public void finPrueba() {
		
		System.out.println("--------------");
		System.out.println("fin de prueba");
		System.out.println("--------------");
		
	}	
		
	@AfterTest
	public void cierreNavegador() {
			
		driver.quit();
		
	}
	
	@AfterSuite
	public void finSuite() {
		
		System.out.println("------------");
		System.out.println("Fin de Suite");
		System.out.println("------------");
	}
}	
