package pruebas;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.openqa.selenium.edge.EdgeDriver;

import paginas.paginaLogin;


public class PracticaM5 {
	
	String url = "http://www.automationpractice.pl/index.php?controller=authentication&back=my-account";
	WebDriver driver;
	paginaLogin login;
	
	@BeforeMethod
	public void setUP() {
		driver= new EdgeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		
	}
	
	@Test(dataProvider= "Datos Login")
	public void loginUser(String email, String password) {
		
		login= new paginaLogin(driver);
		login.ingresarDatos("email","password");
		Assert.assertEquals(login.getTtileForm(),"AUTHENTICATION");
		
	}
	
	@DataProvider(name= "Datos Login")
	public Object[][]getData(){
		
		Object[][] data= new Object[3][2];
		
		data[0][0]="test1z3@gmail.com"; data[0][1]="qwert";
		data[1][0]="test1x4@gmail.com"; data[1][1]="trewq";
		data[2][0]="test1h5@gmail.com"; data[2][1]="trqwe";
		
		return data;
	}
	
	
	
	@AfterMethod
	public void tearDown() {
	
		driver.quit();
	}
}

