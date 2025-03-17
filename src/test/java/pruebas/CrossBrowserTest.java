package pruebas;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class CrossBrowserTest {
	WebDriver driver;
	String url = "http://www.automationpractice.pl/"; 
	
	@BeforeMethod
	@Parameters("navegador")
	public void setUp(String navegador) {
		
	if (navegador.equalsIgnoreCase("Edge")) {
		
		driver= new EdgeDriver();	
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
	
	} else if(navegador.equalsIgnoreCase("Firefox")){
		
		driver= new FirefoxDriver();	
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
	} else {
		
		driver= new ChromeDriver();	
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
	}
		driver.get(url);
		
	}

	@Test
	public void BuscarTexto() {		
		WebElement txtBusqueda= driver.findElement(By.id("search_query_top"));
		txtBusqueda.sendKeys("dress");
		txtBusqueda.sendKeys(Keys.ENTER);
	
	}
	
	@AfterMethod
	public void CerrarNavegador(){
		driver.quit();
	
	}
}
