package EducacionIT_75402.EduIT;

//Para ejecutarlo se hace clic derecho sobre la clase y se selecciona "Run As: 1 JUnit Test"

//Librerias que se necesitaran para ejecutar este archivo:
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class PracticaM1 { 

	//Las variables que necesitaremos para nuestra prueba	
String url = "http://www.automationpractice.pl/"; 


	@Test @Disabled	
public void lab1_test ( ) {
		
		System.out.println ("Hola Mundo de Automatización!!");
    	
		//Se inserta arroba + Test y se importa la libreria haciendo clic derecho sobre Test y se selecciona la libreria org.junit.jupiter.api.Test
		//@Disabled sirve para omitir casos durante la ejecucion de pruebas   		
		
		
    }
	
	@Test @Disabled	
	public void buscarProductoEdge() {
		
		//Paso 1: Definir que navegador vamos a utilizar
		
		WebDriver navegador= new EdgeDriver();
		
		navegador.manage().deleteAllCookies(); //Borra las cookies
		
		navegador.manage().window().maximize(); //Maximiza la ventana
		
		//Paso 2: Abrir la pagina que se va a probar
		
		navegador.get(url);
		
		//Paso 3: Escribir que queremos buscar
		
		WebElement txtBusqueda=navegador.findElement(By.id("search_query_top"));
		txtBusqueda.sendKeys("dress");
		
		//Paso 4: Simular que presionamos Enter
		
		txtBusqueda.sendKeys(Keys.ENTER);
		
		//Paso 5: Cerrar el navegador
		
		navegador.close(); //Cierra el navegador
}

	
@Test
public void buscarProductoFirefox() {
	
	WebDriver navegador= new FirefoxDriver();
	
	navegador.manage().deleteAllCookies();
	
	navegador.manage().window().maximize();
	
	navegador.get(url);
	
	WebElement txtBusqueda=navegador.findElement(By.id("search_query_top"));
	txtBusqueda.sendKeys("dress");
	
	txtBusqueda.sendKeys(Keys.ENTER);
	
	navegador.close();
 }
}
